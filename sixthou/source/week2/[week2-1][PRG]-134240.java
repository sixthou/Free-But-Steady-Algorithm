package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_134240 {

    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder("0");

        for (int i = food.length - 1; i > 0; i--) {
            int cal = i;
            int cnt = food[i];
            for (int j = 0; j < cnt / 2; j++) {
                answer = new StringBuilder(cal + answer.toString() + cal);
            }
        }

        return answer.toString();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] food, String expect) {
        Assertions.assertThat(solution(food)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 6}, "1223330333221"),
                Arguments.of(new int[]{1, 7, 1, 2}, "111303111")
        );
    }
}
