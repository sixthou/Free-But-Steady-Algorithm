package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_178870 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 연속된 부분 수열의 합
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/178870
     * 난이도 : 2
     * 유형 : 투포인터
     * 설명 : 가장 기본적인 투포인터 문제.
     * 예외 :
     **/

    public int[] solution(int[] sequence, int k) {
        int head = 0;
        int tail = 0;
        int answerHead = 0;
        int answerTail = Integer.MAX_VALUE;
        int sum = sequence[0];

        while (true) {
            if (sum < k) {
                tail++;
                if (tail == sequence.length) {
                    break;
                }
                sum += sequence[tail];
            }
            if (sum > k) {
                sum -= sequence[head];
                head++;
            }
            if (sum == k) {
                if (answerTail - answerHead > tail - head) {
                    answerTail = tail;
                    answerHead = head;
                }
                tail++;
                if (tail == sequence.length) {
                    break;
                }
                sum += sequence[tail];
                sum -= sequence[head];
                head++;
            }
        }

        return new int[]{answerHead, answerTail};
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] sequence, int k, int[] expect) {
        Assertions.assertThat(solution(sequence, k)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 3, 4, 5}, 5, new int[]{6, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 7, new int[]{2, 3}),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 6, new int[]{0, 2})
        );
    }
}
