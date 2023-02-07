package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12980 {
    /**
     * 제공자 :
     * 제목 : 점프와 순간 이동
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12980
     * 난이도 : 2
     * 설명 : 문제만 이해하면 쉬움.
     * 예외 :
     **/

    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }

        return ans;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(6, 2),
                Arguments.of(5000, 5)
        );
    }
}
