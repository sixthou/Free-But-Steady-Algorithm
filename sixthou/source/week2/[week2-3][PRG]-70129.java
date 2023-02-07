package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_70129 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 이진 변환 반복하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/70129
     * 난이도 : 2
     * 설명 : Integer.toBinaryString(); 포인트
     * 예외 :
     **/

    public int[] solution(String s) {
        int changeCount = 0;
        int zeroCount = 0;

        while (!"1".equals(s)) {
            int beforeLength = s.length();
            s = s.replaceAll("0", "");
            int afterLength = s.length();
            zeroCount += beforeLength - afterLength;
            s = Integer.toBinaryString(afterLength);
            changeCount++;
        }

        return new int[]{changeCount, zeroCount};
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, int[] expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("110010101001", new int[]{3, 8}),
                Arguments.of("01110", new int[]{3, 3}),
                Arguments.of("1111111", new int[]{4, 1})
        );
    }
}
