package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_131704 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 택배상자
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/131704
     * 난이도 : 2
     * 유형 : 스택, 큐
     * 설명 :
     * 예외 :
     **/

    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }
        int index = 0;

        while (index < order.length) {
            int target = order[index];
            if (!queue.isEmpty() &&queue.peek() == target) {
                queue.poll();
                index++;
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                index++;
                continue;
            }
            if (queue.isEmpty()) {
                break;
            }
            stack.push(queue.poll());
        }

        return index;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] order, int expect) {
        Assertions.assertThat(solution(order)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 3, 2, 1},	5),
                Arguments.of(new int[]{4, 3, 1, 2, 5},	2)
        );
    }
}
