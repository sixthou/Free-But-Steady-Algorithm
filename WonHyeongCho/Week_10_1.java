import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 제공자: Programmers
 * 제목: 숫자 변환하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/154538?language=java
 * 난이도: Level 2
 * 풀이완료시간: 10분
 * 설명: 간단한 BFS 문제. 알고리즘 감 익히기 좋다.
 */
public class Week_10_1 {

    public static void main(String[] args) {
//        int x = 10;
//        int y = 40;
//        int n = 5;

        int x = 0;
        int y = 0;
        int n = 10;

        System.out.println(solution(x, y, n));
    }

    static int solution(int x, int y, int n) {
        if(x == y) return 0;

        Queue<Point> resultQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        resultQueue.add(new Point(x, 0));
        visited.add(x);

        while (!resultQueue.isEmpty()) {
            Point point = resultQueue.poll();

            int number = point.number;
            int level = point.level + 1;

            for(int i = 0; i < 3; i++) {
                int result = 0;

                switch (i) {
                    case 0:
                        result = number * 2;
                        break;
                    case 1:
                        result = number * 3;
                        break;
                    default:
                        result = number + n;
                        break;
                }

                if (result == y) return level;

                if(result < y && !visited.contains(result)) {
                    resultQueue.add(new Point(result, level));
                    visited.add(result);
                }
            }
        }

        return -1;
    }

    static class Point {
        int number;
        int level;

        Point(int number, int level) {
            this.number = number;
            this.level = level;
        }
    }
}
