package programmers;

import java.util.Stack;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_76502 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 괄호 회전하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/76502
     * 난이도 :2
     * 유형 : 월간 코드 챌린지 시즌2
     * 설명 : 복잡하게 생각했는데 그냥 스택문제엿음.
     * 예외 :
     **/

    public int solution(String s) {
        int answer = 0;
        int strLength = s.length();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < strLength; i++) {
            str.append(s, i, strLength)
                    .append(s, 0, i);
            answer += func(str.toString());
            str.delete(0, strLength);
        }

        return answer;
    }

    int func(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (stack.isEmpty() && (now == ']' || now == ')' || now == '}')) {
                return 0;
            }
            if (!stack.isEmpty() && (stack.peek() == '[' && now == ']')) {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && (stack.peek() == '{' && now == '}')) {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && (stack.peek() == '(' && now == ')')) {
                stack.pop();
                continue;
            }
            stack.push(now);
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, int expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("[](){}", 3),
                Arguments.of("}]()[{", 2),
                Arguments.of("[)(]", 0),
                Arguments.of("}}}", 0)
        );
    }

}
