package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_68936 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 쿼드압축 후 개수 세기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/68936
     * 난이도 : 2
     * 유형 : dfs
     * 설명 : 배열다루는건 너무너무 어렵다.... 재귀로 해결...
     * 예외 :
     **/

    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dfs(0, arr.length - 1, 0, arr.length - 1, arr);
        return answer;
    }

    public void dfs(int x1, int x2, int y1, int y2, int[][] arr) {
        if (isCompressible(x1, x2, y1, y2, arr, arr[y1][x1])) {
            if (arr[y1][x1] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }

        dfs(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2, arr);
        dfs(x1, (x1 + x2) / 2, (y1 + y2) / 2 + 1, y2, arr);
        dfs((x1 + x2) / 2 + 1, x2, y1, (y1 + y2) / 2, arr);
        dfs((x1 + x2) / 2 + 1, x2, (y1 + y2) / 2 + 1, y2, arr);
    }

    public boolean isCompressible(int x1, int x2, int y1, int y2, int[][] arr, int var) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (arr[j][i] != var) {
                    return false;
                }
            }
        }
        return true;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] arr, int[] expect) {
        Assertions.assertThat(solution(arr)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1, 1, 0, 0},
                                {1, 0, 0, 0},
                                {1, 0, 0, 1},
                                {1, 1, 1, 1}}
                        , new int[]{4, 9}),
                Arguments.of(new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 0, 0, 0, 1, 1, 1, 1},
                                {0, 1, 0, 0, 1, 1, 1, 1},
                                {0, 0, 0, 0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 1, 0, 0, 1},
                                {0, 0, 0, 0, 1, 1, 1, 1}},
                        new int[]{10, 15})
        );
    }
}
