package programmers;

import java.util.Stack;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_154539 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 뒤에 있는 큰 수 찾기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/154539
     * 난이도 : 2
     * 설명 : 스택
     * 예외 : 배열의 최대길이 1,000,000 건
     **/

    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[length - 1]);
        answer[length - 1] = -1;

        for (int i = length - 2 ; i >= 0; i--) {
            int now = numbers[i];
            int top = stack.peek();

            while (top <= now && !stack.isEmpty()) {
                stack.pop();
                if (stack.isEmpty()) {
                    top = -1;
                    continue;
                }
                top = stack.peek();
            }
            answer[i] = top;
            stack.push(now);
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] param ,int[] expect) {
        Assertions.assertThat(solution(param)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{9, 1, 5, 3, 6, 2}, new int[]{-1, 5, 6, 6, -1, -1}),
                Arguments.of(new int[]{2, 3, 3, 5}, new int[]{3, 5, 5, -1})
                );
    }
}
