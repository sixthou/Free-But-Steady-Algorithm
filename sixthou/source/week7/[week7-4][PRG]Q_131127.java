package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_131127 {


    /**
     * 제공자 : 프로그래머스
     * 제목 : 할인행사
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/131127
     * 난이도 : 2
     * 유형 : 단순 구현
     * 설명 :
     * 예외 :
     **/

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        IntStream.range(0, want.length)
                .forEach(i -> wantMap.put(want[i], number[i]));

        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            tempMap.put(discount[i], tempMap.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            tempMap.put(discount[i + 9], tempMap.getOrDefault(discount[i + 9], 0) + 1);
            answer += comp(wantMap, tempMap);
            tempMap.put(discount[i], tempMap.get(discount[i]) - 1);
        }

        return answer;
    }

    public int comp(Map<String, Integer> wantMap, Map<String, Integer> tempMap) {
        for (String key : wantMap.keySet()) {
            if (!Objects.equals(wantMap.get(key), tempMap.get(key))) {
                return 0;
            }
        }
        return 1;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] want, int[] number, String[] discount, int expect) {
        Assertions.assertThat(solution(want, number, discount)).isEqualTo(expect);
    }




    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"},3),
                Arguments.of(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"},	0)
        );
    }
}
