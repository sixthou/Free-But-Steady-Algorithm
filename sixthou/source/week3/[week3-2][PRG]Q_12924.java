package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12924 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 숫자의 표현
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12924
     * 난이도 : 2
     * 설명 : 연습문제
     * 예외 :
     **/

    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            int j = i;
            while (sum < n) {
                sum += j;
                j++;
            }
            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(15, 4),
                Arguments.of(3, 2),
                Arguments.of(1, 1)
        );
    }
}
