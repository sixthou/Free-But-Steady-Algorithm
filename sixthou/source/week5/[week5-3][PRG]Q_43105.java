package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_43105 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 정수 삼각형
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43105
     * 난이도 : 3
     * 유형 : DP
     * 설명 : DP 가장 기본 문제.. bottom up으로 해결.
     * 예외 :
     **/

    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2 ; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }



    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] triangle, int expect) {
        Assertions.assertThat(solution(triangle)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}, 30)
        );
    }

}
