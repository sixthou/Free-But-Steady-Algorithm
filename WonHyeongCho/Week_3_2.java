import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 제공자: Programmers
 * 제목: 뒤에 있는 큰 수 찾기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 난이도: 2
 * 풀이완료시간: 30/30
 * 성공여부: 실패
 * 설명: 자신의 위치 보다 뒤에 있는 수 중 가장 가까이 있는 수 찾기 --> 시간 초과 체크, 스택을 사용해서 앞에 원소들을 계속 제거 한다.
 * 예외:
 */
public class Week_3_2 {

    public static void main(String[] args) {

//        int[] numbers = {2, 3, 3, 5};
        int[] numbers = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) answer[stack.pop()] = numbers[i];
            stack.push(i);
        }

        while (!stack.isEmpty()) answer[stack.pop()] = -1;

        return answer;
    }

    /*
     * 아래 코드보다 더 느렸다...
     */
//    public static int[] solution(int[] numbers) {
//        int[] answer = new int[numbers.length];
//        int[][] orders = new int[numbers.length][2];
//
//        for(int i = 0; i < numbers.length; i++) {
//            orders[i][0] = i;
//            orders[i][1] = numbers[i];
//        }
//
//        Arrays.sort(orders, Comparator.comparing((int[] o) -> o[1]).reversed());
//
//        for (int[] order : orders) {
//            System.out.println(Arrays.toString(order));
//        }
//
//        for(int i = 0; i < numbers.length; i++) {
//
//            if(hasMoreBigNumber(i, numbers[i], orders)) {
//                for(int j = i+1; j < numbers.length; j++) {
//                    if(numbers[j] > numbers[i]) {
//                        answer[i] = numbers[j];
//                        break;
//                    }
//                }
//            }
//            else {
//                answer[i] = -1;
//            }
//        }
//
//        return answer;
//    }
//
//    public static boolean hasMoreBigNumber(int index, int number, int[][] orders) {
//        for (int[] order : orders) {
//            if (index < order[0] && number < order[1]) return true;
//        }
//
//        return false;
//    }

    /*
     * 시간 초과 생각해서 구혔했지만 실패
     */
//    public static int[] solution(int[] numbers) {
//        int[] answer = new int[numbers.length];
//        int maxNumberIndex = findMaxNumber(0, numbers);
//
//        for(int i = 0; i < numbers.length; i++) {
//            if(i == maxNumberIndex && i != numbers.length-1) {
//                maxNumberIndex = findMaxNumber(i+1, numbers);
//            }
//
//            if(numbers[i] >= numbers[maxNumberIndex]) {
//                answer[i] = -1;
//            } else {
//                for(int j = i+1; j < numbers.length; j++) {
//                    if(numbers[j] > numbers[i]) {
//                        answer[i] = numbers[j];
//                        break;
//                    }
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public static int findMaxNumber(int index, int[] numbers) {
//        int maxIndex = index;
//        for(int i = index; i < numbers.length; i++) {
//            if(numbers[maxIndex] < numbers[i]) maxIndex = i;
//        }
//        return maxIndex;
//    }
}
