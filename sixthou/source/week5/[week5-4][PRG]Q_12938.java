package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12938 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 최고의 집합
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12938
     * 난이도 : 3
     * 유형 : 구현
     * 설명 : 2중 for문으로 문제를 풀었는데 다른 사람 풀이를 보니 단일 포문으로도 해결이 가능했다. 
     * 예외 :
     **/

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int tmp = s;
        int window = 0;
        while (window < n) {
            if (tmp < n - window) {
                window++;
                continue;
            }
            int val = tmp / (n - window);
            tmp = tmp % (n - window);
            funSum(window, answer, val);
            window++;
        }

        return answer;
    }

    void funSum(int start, int[] arr, int val) {
        for (int i = start; i < arr.length; i++) {
            arr[i] += val;
        }
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int s, int[] expect) {
        Assertions.assertThat(solution(n, s)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(2, 9, new int[]{4, 5}),
                Arguments.of(2, 1, new int[]{-1}),
                Arguments.of(2, 8, new int[]{4, 4}),
                Arguments.of(4, 11, new int[]{2, 3, 3, 3})
        );
    }
}
