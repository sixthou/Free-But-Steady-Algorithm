import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 제공자: Programmers
 * 제목: 스코빌 지수
 * URL: https://programmers.co.kr/skill_checks/483465
 * 난이도: Level 2
 * 풀이완료시간: 20
 * 설명:
 */
public class Week_14_1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    static int solution(int[] scoville, int K) {
        int answer = 0;

        Arrays.sort(scoville);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int food : scoville) queue.add(food);

        int food = queue.poll();

        if(food == 0) return -1;

        while(food < K) {

            if(answer == scoville.length-1) {
                answer = -1;
                break;
            }

            int nextFood = queue.poll();

            food = food + (nextFood * 2);

            queue.add(food);

            food = queue.poll();

            answer++;
        }

        return answer;
    }
}
