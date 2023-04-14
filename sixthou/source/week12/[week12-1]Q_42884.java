package programmers;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_42884 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 단속카메라
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42884
     * 난이도 : 3
     * 유형 : 탐욕법
     * 설명 : 탐욕법으로 분류가 되어있긴한데 풀이는 그냥,,,?
     * 예외 :
     **/

    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int lastCameraPosition = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > lastCameraPosition) {
                answer++;
                lastCameraPosition = routes[i][1];
            }
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] routes, int expect) {
        Assertions.assertThat(solution(routes)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[][]{{-20,-15}, {-14,-5}, {-18,-13},{-5,-3}}, 2)
        );
    }
}
