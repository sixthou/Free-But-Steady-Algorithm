package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_49994 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 방문 길이
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/49994
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 쉽게 생각하고 visted 삼중배열을 생성해 문제를 풀었는데 방향성 때문에 문제가 발생했다. 왼쪽으로 이동한것과 오른족으로 이동한게 동일한 길이 될 수 잇다.
     *      Point를 생성하고 Set을 통해 중복처리 햇다. equals와 hashcode는 역시 중요한것.
     * 예외 :
     **/

              //U, D, R, L
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    public int solution(String dirs) {
        Map<String, Integer> dirMap = new HashMap<>();
        dirMap.put("U", 0);
        dirMap.put("D", 1);
        dirMap.put("R", 2);
        dirMap.put("L", 3);

        int x = 0;
        int y = 0;
        Set<Point> points = new HashSet<>();

        String[] dirToken = dirs.split("");
        for (String dir : dirToken){
            Integer p = dirMap.get(dir);
            if (isPossible(x + dx[p], y + dy[p])) {
                points.add(new Point(x, y, x + dx[p], y + dy[p]));
                x += dx[p];
                y += dy[p];
            }
        }

        return points.size();
    }

    public class Point {
        int nowX;
        int nowY;
        int toX;
        int toY;

        public Point(int nowX, int nowY, int toX, int toY) {
            this.nowX = nowX;
            this.nowY = nowY;
            this.toX = toX;
            this.toY = toY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Point point = (Point) o;

            return (nowY == point.nowY && nowX == point.nowX && toY == point.toY && toX == point.toX)
                    || (nowY == point.toY && nowX == point.toX && toY == point.nowY && toX == point.nowX);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nowX, nowY, toX, toY) + Objects.hash(toX, toY, nowX, nowY);
        }
    }

    boolean isPossible(int x, int y) {
        return x >= -5 && y >= -5 && x <= 5 && y <= 5;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String dirs, int expect) {
        Assertions.assertThat(solution(dirs)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("ULURRDLLU", 	7),
                Arguments.of("LULLLLLLU", 	7)
        );
    }
}
