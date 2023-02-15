import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 제공자: Programmers
 * 제목: 야근 지수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12927
 * 난이도: 3
 * 풀이완료시간: 25/30
 * 성공여부: 성공
 * 설명: works 배열에서 n을 뺏을 때 가장 낮은 제곱의 합, 최대값을 줄이는 방식으로 접근, 계속 최대값을 찾기위해 우선순위 큐 사용
 * 예외:
 */
public class Week_4_4 {

    public static void main(String[] args) {
        int n = 4;
//        int[] works = {4, 3, 3};
        int[] works = {8, 7, 8};

        System.out.println(solution(n, works));
    }

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int workTime: works) queue.offer(workTime);

        while(n > 0) {
            int workTime = queue.poll();

            if(workTime == 0) break;

            workTime--;
            queue.offer(workTime);
            n--;
        }

        long answer = 0;

        for(int workTime : queue) answer += ((long) workTime * workTime);

        return answer;
    }
}
