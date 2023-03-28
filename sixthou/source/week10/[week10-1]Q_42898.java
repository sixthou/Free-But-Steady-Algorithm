package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_42898 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 등굣길
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42898
     * 난이도 : 3
     * 유형 : 동적계획법
     * 설명 : BFS로 풀이 시도하다 실패했다. DP로 해결하는 방법에
     * 예외 :
     **/


    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];

        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        if (map[1][2] != -1) {
            map[1][2] = 1;
        }
        if (map[2][1] != -1) {
            map[2][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != -1) {
                    if (map[i][j - 1] != -1) {
                        map[i][j] = (map[i][j] + map[i][j - 1]) % 1_000_000_007;
                    }
                    if (map[i-1][j] != -1) {
                        map[i][j] = (map[i][j] + map[i - 1][j]) % 1_000_000_007;
                    }
                }
            }
        }

        return map[n][m];
    }




    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int m, int n, int[][] puddles, int expect) {
        Assertions.assertThat(solution(m, n, puddles)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(4,3, new int[][]{{2, 2}},	4),
                Arguments.of(4, 3, new int[][]{}, 10),
                Arguments.of(2, 2, new int[][]{}, 2),
                Arguments.of(3, 3, new int[][]{}, 6),
                Arguments.of(3, 3, new int[][]{{2, 2}}, 2),
                Arguments.of(3, 3, new int[][]{{2, 3}}, 3),
                Arguments.of(3, 3, new int[][]{{1, 3}}, 5),
                Arguments.of(3, 3, new int[][]{{1, 3}, {3, 1}}, 4),
                Arguments.of(3, 3, new int[][]{{1, 3}, {3, 1}, {2, 3}}, 2),
                Arguments.of(3, 3, new int[][]{{1, 3}, {3, 1}, {2, 3}, {2, 1}}, 1),
                Arguments.of(7, 4, new int[][]{{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}}, 0),
                Arguments.of(4, 4, new int[][]{{3, 2}, {2, 4}}, 7),
                Arguments.of(100, 100, new int[][]{}, 690285631)
        );
    }
}
