import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programers
 * 제목: 두 큐 합 같게 만들기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * 난이도: 2
 * 풀이완료시간: /50
 * 성공여부: 성공
 * 설명:
 * 예외:
 */
public class Week_2_3 {

    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};

        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        System.out.println(solution(queue1, queue2));
    }

    // 시간초과 --> 스트리으로 SUM 삭제, 최대 이동수 일 경우 break 추가
    // 답이 틀렸던 이유는 스트림 Wrapper 클래스로 SUM 할경우 값이 틀려짐... 왜일까?
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long firstSum = Arrays.stream(queue1).sum();
        long sum = Arrays.stream(queue1).sum() + Arrays.stream(queue2).sum();
        if(sum%2 == 1) return -1;

        long halfSum = sum/2;

        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++) {
            first.add(queue1[i]);
            second.add(queue2[i]);
        }

        while(!first.isEmpty() && !second.isEmpty()) {
            if(firstSum > halfSum) {
                int firstNumber = first.poll();
                firstSum = firstSum - firstNumber;
                second.add(firstNumber);
            } else if (firstSum < halfSum) {
                int secondNumber = second.poll();
                firstSum = firstSum + secondNumber;
                first.add(secondNumber);
            } else {
                break;
            }

            answer++;

            if(answer > queue1.length * 4) {
                answer = -1;
                break;
            }
        }

        if(first.isEmpty() || second.isEmpty()) {
            answer = -1;
        }

        return answer;
    }

    // 시간 초과 발생, 정답 틀림
//    public static int solution(int[] queue1, int[] queue2) {
//        int answer = 0;
//
//        long sum = Arrays.stream(queue1).sum() + Arrays.stream(queue2).sum();
//        if(sum%2 == 1) return -1;
//
//        long halfSum = sum/2;
//
//        Queue<Integer> first = new LinkedList<>();
//        Queue<Integer> second = new LinkedList<>();
//
//        for(int i = 0; i < queue1.length; i++) {
//            first.add(queue1[i]);
//            second.add(queue2[i]);
//        }
//
//        int firstSum = first.stream().mapToInt(Integer::intValue).sum();
//
//        while(!first.isEmpty() && !second.isEmpty()) {
//            if(firstSum > halfSum) {
//                int firstNumber = first.poll();
//                firstSum = firstSum - firstNumber;
//                second.add(firstNumber);
//            } else if (firstSum < halfSum) {
//                int secondNumber = second.poll();
//                firstSum = firstSum + secondNumber;
//                first.add(secondNumber);
//            } else {
//                break;
//            }
//
//            answer++;
//        }
//
//        if(first.isEmpty() || second.isEmpty()) {
//            answer = -1;
//        }
//
//        return answer;
//    }
}
