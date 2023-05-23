package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.LongBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_67257 {

    /**
     * 제공자 : 프로그래머스 - 2020 카카오 인턴십
     * 제목 : [카카오 인턴] 수식 최대화
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/67257
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 카카오 문제 정말 싫다.
     * 예외 :
     **/

    String[] op = new String[]{
            "*+-", "*-+",
            "+-*", "+*-",
            "-+*", "-*+"};

    static Map<String, LongBinaryOperator> operationMap = new HashMap<>();
    static {
        operationMap.put("+", (a, b) -> a + b);
        operationMap.put("-", (a, b) -> a - b);
        operationMap.put("*", (a, b) -> a * b);
    }

    public long solution(String expression) {
        long answer = 0;
        List<Long> numbers = Arrays.stream(expression.split("\\D")).map(Long::parseLong)
                .collect(Collectors.toList());
        List<String> opcodes = Arrays.stream(expression.split("\\d")).filter(s -> !"".equals(s))
                .collect(Collectors.toList());
        for (String s : op) {
            answer = Math.max(answer, func(numbers, opcodes, s.split("")));
        }
        return answer;
    }

    public long func(List<Long> number, List<String> opcode, String[] priorities) {
        List<Long> numbers = new ArrayList<>(number);
        List<String> opcodes = new ArrayList<>(opcode);

        for (String priority : priorities) {
            for (int i = 0 ;  i < opcodes.size(); i++) {
                if (priority.equals(opcodes.get(i))) {
                    numbers.set(i, operationMap.get(priority).applyAsLong(numbers.get(i), numbers.get(i + 1)));
                    numbers.remove(i + 1);
                    opcodes.remove(i);
                    i--;
                }
            }
        }
        return Math.abs(numbers.get(0));
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String expression, long expect) {
        Assertions.assertThat(solution(expression)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("100-200*300-500+20", 60420),
                Arguments.of("50+6+3*2", 118),
                Arguments.of("50*6-3*2", 300)
        );
    }
}
