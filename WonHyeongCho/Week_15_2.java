import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 제공자: Programmers
 * 제목: 무인도 여행
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 난이도: Level 2
 * 풀이완료시간: 20분
 * 설명: EASY!
 */
public class Week_15_2 {

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X","X231X", "1XXX1"};

        System.out.println(Arrays.toString(solution(maps)));
    }

    static int[] solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        int[][] visited = map.clone();

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                    visited[i][j] = -1;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        List<Integer> periods = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(visited[i][j] != -1) {
                    periods.add(calcPeriod(i, j, map, visited));
                }
            }
        }

        if(periods.isEmpty()) periods.add(-1);

        return periods.stream().sorted().mapToInt(i -> i).toArray();
    }

    static int calcPeriod(int row, int col, int[][] map, int[][] visited) {
        int period = map[row][col];
        visited[row][col] = -1;

        System.out.println("(" + row + ", " + col + ") " + period);

        if(row != 0 && map[row-1][col] != -1) {
            period += calcPeriod(row-1, col, map, visited);
        }
        if(row != map.length-1 && map[row+1][col] != -1) {
            period += calcPeriod(row+1, col, map, visited);
        }
        if(col != 0 && map[row][col-1] != -1) {
            period += calcPeriod(row, col-1, map, visited);
        }
        if(col != map[0].length-1 && map[row][col+1] != -1) {
            period += calcPeriod(row, col+1, map, visited);
        }

        return period;
    }
}
