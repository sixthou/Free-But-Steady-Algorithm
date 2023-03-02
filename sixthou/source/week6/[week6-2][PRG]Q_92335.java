package programmers;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_92335 {



    /**
     * 제공자 : 프로그래머스
     * 제목 : k진수에서 소수 개수 구하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/92335
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 세상에.... Integer.toString(n,K) 하면 진수변화해서 값을 뽑아준다... 몰랏던것 채크!
     *      소수를 구할때는 제곱근 사용할것! /2로 해서 체크했더니 1번 테스트케이스에서 자꾸 시간초과가 걸렸다.
     * 예외 :
     **/

    public int solution(int n, int k) {
        return (int) Arrays.stream(toKString(n, k).split("0"))
                .filter(str -> !str.isEmpty())
                .map(Long::parseLong)
                .filter(this::isPrime)
                .count();

    }

    String toKString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n / k > 0) {
            sb.append(n % k);
            n = n / k;
        }

        sb.append(n);
        return sb.reverse().toString();

    }

    boolean isPrime(long n) {
        double target = Math.sqrt(n) + 1;
        if (n == 1) {
            return false;
        }

        for (long i = 2; i <= target / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int k, int expect) {
        Assertions.assertThat(solution(n, k)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(437674, 3, 3),
                Arguments.of(1, 3, 0),
                Arguments.of(110011, 10, 2)
        );
    }


}
