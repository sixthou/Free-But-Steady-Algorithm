import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programmers
 * 제목: 미로 탈출
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * 난이도: Level 2
 * 풀이완료시간: 30분
 * 설명: 갈첮가룰 2본 하면 된다. 다만 출구와 레버를 여러번 지날수 있다는 점을 주목! 예외 처리 해아함
 */
public class Week_15_3 {

    public static void main(String[] args) {
//        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps = {"SLOOO"
                        ,"EOXLE"
                        ,"OOOOO"
                        ,"OXXXX"
                        ,"OOOOX"};

        System.out.println(solution(maps));
    }

    static int solution(String[] maps) {
        String[][] maze = new String[maps.length][maps[0].length()];

        int startX = 0;
        int startY = 0;

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                maze[i][j] = String.valueOf(maps[i].charAt(j));

                if(maze[i][j].equals("S")) {
                    startX = j;
                    startY = i;
                }
            }
        }

        Point middle = find(startX, startY, 0, maze, "Lever");
        if(middle == null) return -1;

        Point exit = find(middle.x, middle.y, middle.level, maze, "Exit");
        if(exit == null) return -1;

        return exit.level;
    }

    static Point find(int startX, int startY, int level, String[][] maze, String find) {

        int[] dx = {0, 1, 0, -1};   // 북, 동, 남, 서
        int[] dy = {-1, 0, 1, 0};

        int[][] visited = new int[maze.length][maze[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, level));

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= maze[0].length
                        || nextY < 0 || nextY >= maze.length) continue;

                if ((visited[nextY][nextX] == 0 && maze[nextY][nextX].equals("O"))
                        || (find.equals("Lever") && maze[nextY][nextX].equals("E"))
                        || (find.equals("Exit") && maze[nextY][nextX].equals("S"))) {
                    queue.add(new Point(nextX, nextY, current.level + 1));
                    visited[nextY][nextX] = 1;
                } else if ((find.equals("Lever") && maze[nextY][nextX].equals("L"))
                        || (find.equals("Exit") && maze[nextY][nextX].equals("E"))) {
                    return new Point(nextX, nextY, current.level + 1);
                }
            }
        }

        return null;
    }

    static class Point {
        int x;
        int y;
        int level;

        Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}
