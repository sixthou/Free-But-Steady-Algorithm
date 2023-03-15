package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_42888 {



    /**
     * 제공자 : 프로그래머스
     * 제목 : 오픈채팅방
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42888
     * 난이도 : 2
     * 유형 : 맵
     * 설명 : 간단한 map 문제
     * 예외 :
     **/

    public String[] solution(String[] record) {

        Map<String, String> idMap = new HashMap<>();

        List<String[]> tokens = Arrays.stream(record)
                .map(s -> s.split(" "))
                .collect(Collectors.toList());

        tokens.stream()
                .filter(token -> "Enter".equals(token[0]) || "Change".equals(token[0]))
                .forEach(token -> idMap.put(token[1], token[2]));

        return tokens.stream()
                .filter(token -> !"Change".equals(token[0]))
                .map(token -> "Enter".equals(token[0]) ? idMap.get(token[1]) + "님이 들어왔습니다." :idMap.get(token[1]) + "님이 나갔습니다.")
                .toArray(String[]::new);

    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] record, String[] expect) {
        Assertions.assertThat(solution(record)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}
                        , new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."})
        );
    }
}
