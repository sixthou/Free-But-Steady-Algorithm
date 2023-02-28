package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12927 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 야근 지수
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12927
     * 난이도 : 3
     * 유형 : 구현
     * 설명 : 우선순위 큐로 풀었다.
     * 예외 :
     **/

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (!pq.isEmpty() && n > 0) {
            n--;
            int tmp = pq.poll() - 1;
            if (tmp == 0) {
                continue;
            }
            pq.offer(tmp);
        }

        return pq.stream().mapToLong(i -> (long) i * i).sum();
    }




    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int[] works, long expect) {
        Assertions.assertThat(solution(n, works)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(4, new int[]{4, 3, 3},	12),
                Arguments.of(1, new int[]{2, 1, 2},	6),
                Arguments.of(3, new int[]{1,1},	0)
        );
    }

}
