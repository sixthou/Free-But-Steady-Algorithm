package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12945 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 피보나치 수
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12945
     * 난이도 : 2
     * 설명 : 연습문제
     * 예외 : 오버플로우와 메모리
     **/

    public int solution(int n) {
        int[] ints = new int[n+1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = (ints[i - 1] + ints[i - 2]) % 1234567;
        }
        return ints[n] % 1234567;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(3, 2),
                Arguments.of(5, 5)
        );
    }
}
