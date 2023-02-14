package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12914 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 멀리 뛰기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12914
     * 난이도 : 2
     * 유형 : 연습문제
     * 설명 : 재귀를 통해 브루트포스로 답을 찾아보려 했는데 피보나치 수열이었다.
     * 예외 :
     **/

    public long solution(int n) {
        long answer = 0;
        int[] fibo = new int[n + 2];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n + 1; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return fibo[n + 1] % 1234567;
    }


   /* public long answer = 0;

    public long solution(int n) {
        long answer = 0;
        run(0, n, 0);
        return answer;
    }

    public void run(int depth, int target, long answer) {
        if (depth == answer) {
            answer++;
            return;
        }
        if (depth > target) {
            return;
        }
        run(depth + 1, target, answer);
        run(depth + 2, target, answer);
    }*/

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, long expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(4, 5),
                Arguments.of(3, 3)
        );
    }
}
