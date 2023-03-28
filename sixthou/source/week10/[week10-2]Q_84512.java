package programmers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_84512 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 모음사전
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/84512
     * 난이도 : 2
     * 유형 : 완전탐색
     * 설명 : 그냥 쉬운 완탐
     * 예외 :
     **/
    static String[] strings = {"A", "E", "I", "O", "U"};
    static Map<String, Integer> map = new LinkedHashMap<>();
    static {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            fun("", 0, i, list);
        }
        list.sort(String::compareTo);
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }
    }

    public int solution(String word) {
        return map.get(word);
    }

    public static void fun(String tmp, int index, int target, ArrayList<String> list ) {
        if (index == target) {
            list.add(tmp);
            return;
        }

        for (int i = 0; i < 5; i++) {
            tmp += strings[i];
            fun(tmp, index + 1, target, list);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String word, int expect) {
        Assertions.assertThat(solution(word)).isEqualTo(expect);
    }





    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("AAAE", 10),
                Arguments.of("I", 1563),
                Arguments.of("EIO", 1189),
                Arguments.of("AAAAE", 6)
        );
    }

}
