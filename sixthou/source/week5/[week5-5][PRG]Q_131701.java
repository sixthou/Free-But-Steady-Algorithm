package programmers;

import java.util.HashSet;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_131701 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 연속 부분 수열 합의 개수
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/131701
     * 난이도 : 2
     * 유형 : 단순구현
     * 설명 : 3중 for문으로 해결한게 아쉽다. 다른 방법이 있을까? 2중 for문으로도 풀이가 가능한듯하다. set을 활용한 중복처리도 핵심인듯
     * 예외 :
     **/

    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for (int window = 1; window <= elements.length; window++) {
            for (int start = 0; start < elements.length; start++) {
                int sum = 0;
                for (int i = 0; i < window; i++) {
                    sum += elements[(start + i) % elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] elements, int expect) {
        Assertions.assertThat(solution(elements)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{7,9,1,1,4}, 18)
        );
    }
}
