package programmers;


import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_77885 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 2개 이하로 다른 비트
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/77885
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 이런 문제가 가장 어려운듯. 완탐으로 했다가 실패하고 팁을 얻어서 해결했다.
     * 예외 :
     **/

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        IntStream.iterate(0, i -> i + 1)
                .limit(numbers.length)
                .forEach(i -> answer[i] = find(numbers[i]));

        return answer;
    }

    long find(long num) {
        if (num % 2 == 0) {
            return num + 1;
        }

        String str = "0" + Long.toBinaryString(num);
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                index = str.length() - i -1 ;
                break;
            }
        }

        return (long) (num + Math.pow(2, index) - Math.pow(2, index - 1));
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(long[] numbers, long[] expect) {
        Assertions.assertThat(solution(numbers)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new long[]{2, 7}, new long[]{3, 11}),
                Arguments.of(new long[]{1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100}
                        , new long[]{1002, 338, 1, 2, 334, 674, 347, 222, 899, 998, 122, 1019, 666, 781, 893, 422, 223, 257, 513, 129, 101})
        );
    }
}
