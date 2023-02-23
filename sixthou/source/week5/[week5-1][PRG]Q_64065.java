package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_64065 {


    /**
     * 제공자 : 프로그래머스
     * 제목 : 튜플
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/64065
     * 난이도 : 2
     * 유형 : 2019 카카오 개발자 겨울 인턴십
     * 설명 : 스트림으로 풀어보려고 했는데 지저분하게 풀이된거 같아 아쉽다.
     * 예외 :
     **/

    public int[] solution(String s) {
        Set<Integer> answer = new LinkedHashSet<>();

        Arrays.stream(s.substring(2, s.length() - 2).split("},\\{"))
                .collect(Collectors.toList())
                .stream().map(i -> Arrays.stream(i.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .sorted(Comparator.comparing(List::size))
                .collect(Collectors.toList())
                .forEach(answer::addAll);


        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, int[] expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("{{2},{2,1},{2,1,3},{2,1,3,4}}",	new int[]{2, 1, 3, 4}),
                Arguments.of("{{1,2,3},{2,1},{1,2,4,3},{2}}",	new int[]{2, 1, 3, 4}),
                Arguments.of("{{20,111},{111}}",	new int[]{111, 20}),
                Arguments.of("{{123}}",	new int[]{123}),
                Arguments.of("{{4,2,3},{3},{2,3,4,1},{2,3}}",	new int[]{3, 2, 4, 1})
        );
    }
}
