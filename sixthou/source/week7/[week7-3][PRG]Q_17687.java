package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17687 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : N진수 게임
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17687
     * 난이도 : 2
     * 유형 : 단순구현
     * 설명 : Integer.toString 까먹지 말도록
     * 예외 :
     **/

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(index, n));
            index++;
        }
        String targetString = sb.toString().toUpperCase();
        sb.setLength(0);

        index = 1;
        p = p % m;
        while (sb.length() < t) {
            if (index % m == p) {
                sb.append(targetString.charAt(index -1 ));
            }
            index++;
        }

        return sb.toString();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int t, int m, int p, String expect) {
        Assertions.assertThat(solution(n, t, m, p)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(2, 4, 2, 1, "0111"),
                Arguments.of(16, 16, 2, 1, "02468ACE11111111"),
                Arguments.of(16, 16, 2, 2, "13579BDF01234567")
        );
    }
}
