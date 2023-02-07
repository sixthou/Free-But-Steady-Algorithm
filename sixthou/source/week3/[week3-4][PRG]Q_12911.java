package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12911 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 다음 큰 숫자
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12911
     * 난이도 : 2
     * 설명 : 처음 코드가 정확성은 맞았는데 효율성에서 틀림. Integet.Bitcount 함수를 활용하면 쉽게 해결 가능함.
     * 예외 :
     **/

    public int solution(int n) {
        int bitCount = Integer.bitCount(n);
        int number = n + 1;

        while (bitCount != Integer.bitCount(number)) {
            number++;
        }

        return number;
    }

    /**
     * 효율성에서 문제있음.
     */
   /*
   public int solution(int n) {
        int number = n;

        long count = Integer.toBinaryString(number)
                .chars()
                .filter(i -> i == '1')
                .count();

        while (true) {
            number++;
            long nextCount = Integer.toBinaryString(number)
                    .chars()
                    .filter(i -> i == '1')
                    .count();
            if (count == nextCount) {
                break;
            }
        }

        return number;
    }*/

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(78, 83),
                Arguments.of(15, 23)
        );
    }
}
