package programmers;

import java.util.Stack;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12973 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 짝지어 제거하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=java
     * 난이도 : 2
     * 설명 : 시간복잡도를 생각하자. for문으로 풀었을때는 효율성을 통과하지 못했고, stack 으로 O(n)으로 풀어서 통과함.
     * 예외 :
     **/

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, int expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("baabaa", 1),
                Arguments.of("cdcd", 0)
        );
    }

}
