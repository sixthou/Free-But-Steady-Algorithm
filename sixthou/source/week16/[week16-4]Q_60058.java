package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_60058 {

    /**
     * 제공자 : 프로그래머스 - 2020 KAKAO BLIND RECRUITMENT
     * 제목 : 괄호 변환
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/60058
     * 난이도 : 2
     * 유형 : 단순구현
     * 설명 :
     * 예외 :
     **/

    static StringBuilder sb = new StringBuilder();

    public String solution(String p) {
        return func(p);
    }

    private String func(String w) {
        if ("".equals(w)) {
            return "";
        }

        String u = splitBalanceString(w);
        String v = w.substring(u.length());

        if (isRight(u)) {
            return u + func(v);
        } else {
            return "(" + func(v) + ")" + reverseString(u);
        }
    }

    private String reverseString(String s) {
        String[] token = s.split("");
        sb.setLength(0);
        for (int i = 1; i < token.length - 1; i++) {
            if ("(".equals(token[i])) {
                sb.append(")");
                continue;
            }
            sb.append("(");
        }
        return sb.toString();
    }

    private boolean isRight(String s) {
        String[] token = s.split("");
        Queue<String> queue = new LinkedList<>();
        for (String t : token) {
            if (queue.isEmpty()) {
                queue.add(t);
                continue;
            }
            if ("(".equals(queue.peek()) && ")".equals(t)) {
                queue.poll();
                continue;
            }
            queue.add(t);
        }
        return queue.isEmpty();
    }

    private String splitBalanceString(String s) {
        String[] token = s.split("");
        sb.setLength(0);
        int rightOpen = 0;
        int leftOpen = 0;
        for (String t : token) {
            sb.append(t);
            if ("(".equals(t)) {
                rightOpen++;
            } else {
                leftOpen++;
            }
            if (rightOpen == leftOpen) {
                return sb.toString();
            }
        }
        return sb.toString();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String p, String expect) {
        Assertions.assertThat(solution(p)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("()))((()", "()(())()"),
                Arguments.of("(()())()", "(()())()"),
                Arguments.of(")(", "()")
        );
    }

}
