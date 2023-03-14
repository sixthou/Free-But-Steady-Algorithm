package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_92341 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 주차 요금 계산
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/92341
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 복잡하지만 쉬운 카카오식 문제. TreeMap을 기억하자
     * 예외 :
     **/

    private static int basicTime;
    private static int basicFare;
    private static int unitTime;
    private static int unitFare;

    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFare = fees[1];
        unitTime = fees[2];
        unitFare = fees[3];


        Map<String, String> map = new HashMap<>();
        Map<String, Integer> timeMap = new TreeMap<>();

        for(String record : records){
            String[] token = record.split(" ");
            if ("IN".equals(token[2])) {
                map.put(token[1], token[0]);
            }

            if ("OUT".equals(token[2])) {
                timeMap.put(token[1], timeMap.getOrDefault(token[1], 0 ) + timeToMinute(token[0]) - timeToMinute(map.get(token[1])));
                map.remove(token[1]);
            }
        }

        for (String number : map.keySet()) {
            timeMap.put(number, timeMap.getOrDefault(number, 0) + 1439 - timeToMinute(map.get(number)));
        }

        return timeMap.keySet()
                .stream()
                .map(key -> fareCal(timeMap.get(key)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int timeToMinute(String time) {
        List<Integer> collect = Arrays.stream(time.split(":"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return collect.get(0) * 60 + collect.get(1);
    }

    private int fareCal(int useTime) {
        if (useTime > basicTime) {
            return (int) (basicFare + Math.ceil((useTime - basicTime) / (double)unitTime) * unitFare);
        }
        return basicFare;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] fees, String[] records, int [] expect) {
        Assertions.assertThat(solution(fees, records)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}, new int[]{14841}),
                Arguments.of(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}, new int[]{14600, 34400, 5000}),
                Arguments.of(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"},new int[]{0, 591})

        );
    }
}
