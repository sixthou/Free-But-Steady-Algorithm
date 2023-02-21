package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_138476 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 귤 고르기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/138476
     * 난이도 : 2
     * 유형 : 맵
     * 설명 : 단순 맵 문제, 문제를 잘 읽자
     * 예외 :
     **/
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> basket = new HashMap<>();

        for (int obj : tangerine) {
            basket.put(obj, basket.getOrDefault(obj, 0) + 1);
        }

        List<Integer> orderedTangerine = basket.keySet()
                .stream()
                .map(basket::get)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int sum = 0;
        for (int number : orderedTangerine) {
            sum += number;
            answer++;
            if (sum >= k) {
                return answer;
            }
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int k, int[] tangerine, int expect) {
        Assertions.assertThat(solution(k, tangerine)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 	3),
                Arguments.of(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 	2),
                Arguments.of(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}, 	1)
        );
    }
}
