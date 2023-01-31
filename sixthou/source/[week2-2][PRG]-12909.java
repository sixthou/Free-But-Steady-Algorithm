package programmers;

import java.util.Stack;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12909 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 올바른 괄호
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12909
     * 난이도 : 2
     * 설명 :
     * 예외 : 효율성 검사가 포인트
     */


    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }

            if (s.charAt(i) == ')') {
                return false;
            }
            stack.push(1);
        }

        return stack.isEmpty();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, boolean expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("()()", true),
                Arguments.of("(())()", true),
                Arguments.of(")()(", false),
                Arguments.of("(()(", false)
        );
    }
}
