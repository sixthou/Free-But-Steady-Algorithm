package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_154540 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 무인도 여행
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/154540
     * 난이도 : 2
     * 유형 : bfs
     * 설명 :
     * 예외 :
     **/

    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int[] solution(String[] maps) {
        List<Integer> ans = new ArrayList<>();
        String[][] map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Point> ps = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            String[] split = maps[i].split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = split[j];
                if (!"X".equals(split[j])) {
                    ps.add(new Point(i, j));
                }
            }
        }

        for (Point p : ps) {
            ans.add(doFunc(p, map));
        }

        return ans.size() == 0 ? new int[]{-1} : ans.stream().filter(i -> i != 0).mapToInt(Integer::intValue).sorted().toArray();

    }

    private int doFunc(Point p, String[][] map) {
        if (visited[p.x][p.y]) {
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;
        int count = Integer.parseInt(map[p.x][p.y]);
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            for (int i = 0; i < 4; i++) {
                int tx = nowX + dx[i];
                int ty = nowY + dy[i];
                if (tx >= 0 && tx < map.length && ty >= 0 && ty < map[0].length) {
                    if (!visited[tx][ty] && !"X".equals(map[tx][ty])) {
                        queue.add(new Point(tx, ty));
                        visited[tx][ty] = true;
                        count += Integer.parseInt(map[tx][ty]);
                    }
                }
            }

        }
        return count;
    }

    private static class Point{
        int x;
        int y;

        public Point(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] maps, int[] expect) {
        Assertions.assertThat(solution(maps)).isEqualTo(expect);
    }



    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}, new int[]{1, 1, 27}),
                Arguments.of(new String[]{"XXX", "XXX", "XXX"}, new int[]{-1})
        );
    }
}
