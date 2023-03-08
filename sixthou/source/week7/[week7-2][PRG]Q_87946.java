package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_87946 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 피로도
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/87946
     * 난이도 : 2
     * 유형 : 완전탐색
     * 설명 : 유형을 파악했지만 완탐 구현방법을 떠올리는데 어려움을 겪엇다. 비슷한 문제들 연습으로 풀이법 단련을 해야겟다.
     * 예외 :
     **/



    static int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        permutation(dungeons, visited, 0, k);
        return max;
    }


    public static void permutation(int arr[][], boolean visited[], int depth, int energy) {
        if (depth > max) {
            max = depth;
        }

        if (depth == arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && energy >= arr[i][0]) {
                visited[i] = true;
                permutation(arr, visited, depth+1, energy - arr[i][1]);
                visited[i] = false;
            }
        }
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int k, int[][] dungeons, int expect) {
        Assertions.assertThat(solution(k, dungeons)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}, 3)
        );
    }
}
