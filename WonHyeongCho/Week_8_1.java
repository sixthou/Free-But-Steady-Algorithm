import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 제공자: Programmers
 * 제목: 귤 고르기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * 난이도: Level 2
 * 풀이완료시간: 10분
 * 설명: map을 정렬하고 난 후에 PriorityQueue에 넣지 말고 스트림으로 처리할수 있는 방법은 없을까?
 */
public class Week_8_1 {

    public static void main(String[] args) {

//        int k = 6;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Long> map = Arrays.stream(tangerine).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        PriorityQueue<Long> queue = new PriorityQueue<>((l1, l2) -> (int)(l2 - l1));

        map.entrySet().stream().sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue())).forEach(e -> {
            System.out.println("value: " + e.getValue());
            queue.add(e.getValue());
        });

        queue.forEach(System.out::println);

        for(Long count: queue) {
            k -= count;
            answer++;

            if(k <= 0) break;
        }

        return answer;
    }
}
