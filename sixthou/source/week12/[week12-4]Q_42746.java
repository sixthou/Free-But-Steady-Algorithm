package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_42746 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 가장 큰 수
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42746
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 처음에 문자열로 바꾼다음 하나하나 비교하는 방법으로 시도했는데 문제의 의도를 제대로 파악하지 못했다.
     * 예외 :
     **/

    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted(this::comp)
                .collect(Collectors.joining());
        return answer.startsWith("0") ? "0" : answer;
    }


    private int comp(String a, String b) {
        int compA = Integer.parseInt(a + b);
        int compB = Integer.parseInt(b + a);
        return compB - compA;
    }



    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] numbers, String expect) {
        Assertions.assertThat(solution(numbers)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{3, 33, 333}, "333333"),
                Arguments.of(new int[]{0, 0}, "0"),
                Arguments.of(new int[]{0, 0, 0, 0}, "0"),
                Arguments.of(new int[]{0, 1000, 0, 0}, "1000000"),
                Arguments.of(new int[]{5, 546}, "5546"),
                Arguments.of(new int[]{0, 0, 70}, "7000"),
                Arguments.of(new int[]{12, 121}, "12121"),
                Arguments.of(new int[]{12, 1213}, "121312"),
                Arguments.of(new int[]{21, 212}, "21221"),
                Arguments.of(new int[]{3, 34, 30}, "34330"),
                Arguments.of(new int[]{6, 10, 2}, "6210"),
                Arguments.of(new int[]{3, 30, 34, 5, 9}, "9534330"),
                Arguments.of(new int[]{898, 89}, "89898")
        );
    }

}
