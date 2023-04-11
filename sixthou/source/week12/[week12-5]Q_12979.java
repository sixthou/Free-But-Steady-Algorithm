package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12979 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 기지국 설치
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12979
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 단순하게 생각하는 경향이 있다. 어떻게 인덱스를 다룰것인지 깊이 생각해볼것.
     * 예외 :
     **/

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index < stations.length && i >= stations[index] - w) {
                i = stations[index] + w;
                index++;
            }else {
                answer++;
                i += 2 * w;
            }
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int[] stations, int w, int expect) {
        Assertions.assertThat(solution(n, stations, w)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(11, new int[]{4, 11}, 1, 3),
                Arguments.of(16, new int[]{9}, 2, 3)
        );
    }
}
