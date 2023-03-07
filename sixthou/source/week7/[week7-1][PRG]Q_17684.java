package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17684 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : [3차] 압축
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17684
     * 난이도 : 2
     * 유형 : 2018 KAKAO BLIND RECRUITMENT
     * 설명 : Map에 단어 추가해서 진행하면됨. 난이도가 낮은 카카오 문제라 그런지 문제를 읽어보면 풀이하는 방법이 모두 제시되어있다.
     *      문제를 보면 복작해보이는데 막상 풀이를 하면 술술풀리는 느낌
     * 예외 :
     **/

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        IntStream.range('A', 'Z' + 1)
                .sorted()
                .forEach(i -> map.put(String.valueOf((char) i), map.size() + 1));

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < msg.length()) {
            sb.append(msg.charAt(index));
            if (map.containsKey(sb.toString())) {
                index++;
                continue;
            }
            map.put(sb.toString(), map.size() + 1);
            answer.add(map.get(sb.substring(0, sb.length() - 1)));
            sb.setLength(0);
        }
        answer.add(map.get(sb.toString()));

        return answer.stream().mapToInt(i -> i).toArray();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String msg, int[] expect) {
        Assertions.assertThat(solution(msg)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("KAKAO", new int[]{11, 1, 27, 15}),
                Arguments.of("TOBEORNOTTOBEORTOBEORNOT", new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}),
                Arguments.of("ABABABABABABABAB",new int[]{1, 2, 27, 29, 28, 31, 30} )
        );
    }
}
