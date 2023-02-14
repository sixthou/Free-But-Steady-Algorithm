package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12949 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 행렬의 곱셈
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12949
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 쉬운 문제인데 구현하는데 오랜 시간이 걸렸다. 좀 더 논리적으로 생각할 필요가 있음.
     * 예외 :
     **/

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] arr1, int[][] arr2, int[][] expect) {
        Assertions.assertThat(solution(arr1, arr2)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 4}, {3, 2}, {4, 1}},
                        new int[][]{{3, 3}, {3, 3}},
                        new int[][]{{15, 15}, {15, 15}, {15, 15}}),
                Arguments.of(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},
                        new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}},
                        new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}}),
                Arguments.of(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},
                        new int[][]{{5, 4}, {2, 4}, {3, 1}},
                        new int[][]{{22, 22}, {36, 28}, {29, 20}})
        );
    }
}
