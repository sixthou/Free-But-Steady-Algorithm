package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12900 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 2 x n 타일링
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12900
     * 난이도 : 2
     * 유형 : DP
     * 설명 : 가장 기본적인 DP 문제 유형을 빨리 파악하는게 중요!
     * 예외 :
     **/


    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_007;
        }
        return dp[n];
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(4, 5)
        );
    }
}
