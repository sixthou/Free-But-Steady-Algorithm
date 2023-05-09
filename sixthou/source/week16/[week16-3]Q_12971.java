package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12971 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 스티커 모으기(2)
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12971
     * 난이도 : 3
     * 유형 : dp
     * 설명 : 조합으로 풀었다가 시간초과로 힌트를 얻고 dp로 풀었다. 점화식을 짜기가 쉰지안핟.
     * 예외 :
     **/

    public int solution(int[] sticker) {

        if (sticker.length == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        //1번을 뜯을 경우
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < sticker.length-1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }
        //1번을 안뜯을 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }

        return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] sticker, int expect) {
        Assertions.assertThat(solution(sticker)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 5, 4}, 8),
                Arguments.of(new int[]{14, 6, 5, 11, 3, 9, 2, 10}, 36)
        );
    }
}
