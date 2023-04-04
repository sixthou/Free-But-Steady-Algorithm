import java.util.Arrays;
import java.util.Stack;

/**
 * 제공자: Programmers
 * 제목: 택배 상자
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 난이도: Level 2
 */
public class Week_11_2 {

    public static void main(String[] args) {

//        int[] order = new int[]{4, 3, 1, 2, 5};
//        int[] order = new int[]{5, 4, 3, 2, 1};
        int[] order = new int[]{1, 2, 3, 4, 5};

        System.out.println(solution(order));
    }

    static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> tmp = new Stack<>();

        int targetIndex = 0;
        int target = order[targetIndex];

        int index = 1;

        while (index <= order.length + 1) {

            System.out.println("Target: " + target);
            System.out.println(Arrays.toString(tmp.toArray()));

            if(!isPossible(target, index, order, tmp)) {
                tmp.push(index);
                index++;
            }
            else {
                int top = tmp.pop();

                if(top != target) {
                    index++;
                    tmp.push(top);
                }

                answer++;

                targetIndex += 1;

                if(targetIndex == order.length) break;

                target = order[targetIndex];
            }
        }

        return answer;
    }

    static boolean isPossible(int target, int index, int[] order, Stack<Integer> stack) {

        if(order.length > index) {
            if(order[index] ==  target) return true;
        }

        return !stack.isEmpty() && stack.peek() == target;
    }
}
