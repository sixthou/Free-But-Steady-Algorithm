package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_1844 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 게임 맵 최단거리
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/1844
     * 난이도 : 2
     * 유형 : BFS
     * 설명 : 정형적인 BFS문제
     * 예외 : vistied 체크 위치 주의하자
     **/

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int n;
    int m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] visitMap = new int[n][m];
        visitMap[n-1][m-1] = -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nx = now.getX();
            int ny = now.getY();
            int nd = now.getDepth();
            visitMap[nx][ny] = now.depth;

            for (int i = 0; i < 4; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];
                if (isPossible(tx, ty)){
                    if(maps[tx][ty] != 0 && !visited[tx][ty]) {
                        queue.add(new Node(tx, ty, nd + 1));
                        visited[tx][ty] = true;
                    }
                }
            }

        }
        return visitMap[n-1][m-1];
    }

    boolean isPossible(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

    class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDepth() {
            return depth;
        }
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] maps, int expect) {
        Assertions.assertThat(solution(maps)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}},	11),
                Arguments.of(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}},	-1)
        );
    }
}
