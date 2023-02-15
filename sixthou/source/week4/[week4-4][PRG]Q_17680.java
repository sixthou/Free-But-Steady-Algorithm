package programmers;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17680 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : [1차] 캐시
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17680
     * 난이도 : 2
     * 유형 : 2018 KAKAO BLIND RECRUITMENT
     * 설명 : LRU 알고리즘 구현이 핵심
     * 예외 : 캐시사이즈 0일때 예외처리 고려할것.
     **/

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>(cacheSize);

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (String city : cities) {

            city = city.toLowerCase();

            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
                continue;
            }

            answer += 5;

            if (cache.size() == cacheSize) {
                cache.remove(0);
                cache.add(city);
                continue;
            }
            cache.add(city);
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int cacheSize, String[] cities, int expect) {
        Assertions.assertThat(solution(cacheSize, cities)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 	50),
                Arguments.of(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 	21),
                Arguments.of(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 	60),
                Arguments.of(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 	52),
                Arguments.of(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}, 	16),
                Arguments.of(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 	25)

        );
    }
}
