package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_64062 {
    /**
     * 제공자 : 프로그래머스 - 2019 카카오 개발자 겨울 인턴십
     * 제목 : 징검다리 건너기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/64062
     * 난이도 : 3
     * 유형 : 이분탐색
     * 설명 : 우선순위큐 윈도우 슬라이싱으로 풀려고 했는데 효율성에서 실패 했다. 20만건이 넘으면 이분탐색을 고려해봐여겠다.
     * 예외 :
     **/

    public int solution(int[] stones, int k) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (check(stones, mid, k)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo - 1;
    }

    private boolean check(int[] stones, int target, int k) {
        int skip = 0;
        for (int stone : stones) {
            if (stone < target) {
                skip++;
            } else {
                skip = 0;
            }

            if (skip == k) {
                return false;
            }
        }

        return true;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] stones, int k, int expect) {
        Assertions.assertThat(solution(stones, k)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3, 3)
        );
    }
}
