package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17677 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 뉴스 클러스터링
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17677
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 문제에 풀이 방법이 다 제시가 되어 잇었는데 너무 어렵게 생각했다...
     * 예외 : 토큰으로의 유사성이 없지만 문자열이 같은경우는 유사도 1
     **/

    public int solution(String str1, String str2) {

        if (str1.toUpperCase().equals(str2.toUpperCase())) {
            return 65536;
        }

        int kyo = 0;
        int hap = 0;
        List<String> str1Tokens = stringProcessor(str1);
        List<String> str2Tokens = stringProcessor(str2);

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        str1Tokens.forEach(str -> str1Map.put(str, str1Map.getOrDefault(str, 0) + 1));
        str2Tokens.forEach(str -> str2Map.put(str, str2Map.getOrDefault(str, 0) + 1));

        Set<String> tokenSet = new HashSet<>();
        tokenSet.addAll(str1Map.keySet());
        tokenSet.addAll(str2Map.keySet());

        for (String token : tokenSet) {
            kyo += Math.min(str1Map.getOrDefault(token, 0), str2Map.getOrDefault(token, 0));
            hap += Math.max(str1Map.getOrDefault(token, 0), str2Map.getOrDefault(token, 0));
        }

        return (int) (kyo / (double) hap * 65536);
    }

    List<String> stringProcessor(String str) {

        return IntStream.iterate(0, i -> i + 1)
                .limit(str.length() - 1)
                .boxed()
                .map(i -> str.substring(i, i + 2).toUpperCase())
                .filter(s -> s.replaceAll("[^a-zA-Z]","").length() == 2)
                .collect(Collectors.toList());

    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String str1, String str2, int expect) {
        Assertions.assertThat(solution(str1, str2)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("FRANCE", "french", 16384),
                Arguments.of("handshake", "shake hands", 65536),
                Arguments.of("aa1+aa2", "AAAA12", 43690),
                Arguments.of("A+C", "DEF", 0),
                Arguments.of("E=M*C^2", "e=m*c^2", 65536)

        );
    }

}
