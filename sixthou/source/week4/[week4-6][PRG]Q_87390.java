package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_87390 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : n^2 배열 자르기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/87390
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 주어진 배열에서 값이 어떻게 들어가는지 확인하는게 1번, 필요한 부분만 잘라서 집어 넣는게 2번
     * 예외 :
     **/

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int index = 0;
        for (int i = (int) (left / n); i < (right / n)  + 1; i++) {
            for (int j = i == left / n ? (int) (left % n) : 0; j < n; j++) {
                answer[index++] = Math.max(i + 1, j + 1);
                if (index > right - left) {
                    return answer;
                }
            }
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, long left, long right, int[] expect) {
        Assertions.assertThat(solution(n, left, right)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(3, 2, 5, new int[]{3, 2, 2, 3}),
                Arguments.of(4, 7, 14, new int[]{4, 3, 3, 3, 4, 4, 4, 4})
        );
    }
}
