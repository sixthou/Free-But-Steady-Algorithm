package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12953 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : N개의 최소공배수
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12953
     * 난이도 : 2
     * 설명 : 최소공배수, 최대공약수 풀이만 알면 EASY~
     * 예외 :
     **/

    public int solution(int[] arr) {
        int answer = 1;
        for (int expect : arr) {
            answer = lcm(expect, answer);
        }
        return answer;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] arr, int expect) {
        Assertions.assertThat(solution(arr)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{2,6,8,14}, 168),
                Arguments.of(new int[]{1,2,3}, 6)
        );
    }



}
