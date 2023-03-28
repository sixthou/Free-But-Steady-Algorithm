package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_161989 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 덧칠하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/161989
     * 난이도 : 2
     * 유형 : 단순구현
     * 설명 : 그냥 구현
     * 예외 :
     **/

    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int painted = section[0];

        for (int i = 0; i < section.length; i++) {
            if (painted + m -1 < section[i]) {
                painted = section[i];
                answer++;
            }
        }

        return answer;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int m, int[] section, int expect) {
        Assertions.assertThat(solution(n, m, section)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(8, 4, new int[]{2, 3, 6}, 2),
                Arguments.of(6, 5, new int[]{3}, 1),
                Arguments.of(5, 5, new int[]{3, 4, 5}, 1),
                Arguments.of(5, 4, new int[]{1, 3}, 1),
                Arguments.of(4, 1, new int[]{1, 2, 3, 4}, 4)
        );
    }
}
