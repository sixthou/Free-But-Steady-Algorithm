package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12987 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 숫자 게임
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12987
     * 난이도 : 3
     * 유형 : 단순구현
     * 설명 : 그냥 정렬해서 비교하면되는 문제였다. 왜 3 단계인지..?
     * 예외 :
     **/

    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> aList = Arrays.stream(A)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> bList = Arrays.stream(A)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        int aIndex = 0;
        int bIndex = 0;
        while (true){
            if (aIndex > A.length - 1 || bIndex > B.length - 1) {
                break;
            }
            if (aList.get(aIndex) >= bList.get(bIndex)) {
                aIndex++;
                continue;
            }

            if (bList.get(bIndex) > aList.get(aIndex)) {
                aIndex++;
                bIndex++;
                answer++;
                continue;
            }
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int[] B, int expect) {
        Assertions.assertThat(solution(A, B)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{9, 7, 5, 3}, new int[]{2, 2, 6, 8}, 3),
                Arguments.of(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}, 3),
                Arguments.of(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}, 0)
        );
    }

}
