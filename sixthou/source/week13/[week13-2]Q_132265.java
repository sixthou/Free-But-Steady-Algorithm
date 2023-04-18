package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_132265 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 롤케이크 자르기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/132265
     * 난이도 : 2
     * 유형 : MAP
     * 설명 :
     * 예외 :
     **/

    public int solution(int[] topping) {
        int answer = 0;

        if (topping.length == 0) {
            return 0;
        }

        Map<Integer, Integer> old = new HashMap<>();
        Map<Integer, Integer> young = new HashMap<>();

        old.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            young.put(topping[i], young.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 1; i < topping.length - 1; i++) {
            old.put(topping[i], old.getOrDefault(topping[i], 0) + 1);
            young.put(topping[i], young.get(topping[i]) - 1);
            if (young.get(topping[i]) == 0) {
                young.remove(topping[i]);
            }
            if (old.keySet().size() == young.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] topping, int expect) {
        Assertions.assertThat(solution(topping)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 3, 1, 4, 1, 2},	2),
                Arguments.of(new int[]{1, 2, 3, 1, 4},	0)
        );
    }
}
