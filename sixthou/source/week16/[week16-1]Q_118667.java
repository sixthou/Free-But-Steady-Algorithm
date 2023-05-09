package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_118667 {
    /**
     * 제공자 : 프로그래머스 - 2022 KAKAO TECH INTERNSHIP
     * 제목 : 두 큐 합 같게 만들기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/118667
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 덧셈 연산을 할때는 long 타입에 대한 고려가 필요하다.
     * 예외 :
     **/

    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int sum = Arrays.stream(queue1).sum() + Arrays.stream(queue2).sum();
        int target = sum / 2;
        int maxCount = queue1.length * 3;
        int index = 0;
        if (sum % 2 != 0) {
            return -1;
        }
        Queue<Integer> queA = new LinkedList<>();
        Queue<Integer> queB = new LinkedList<>();
        long sumA = 0, sumB = 0;
        for (int i = 0; i < queue1.length; i++) {
            queA.add(queue1[i]);
            sumA += queue1[i];
            queB.add(queue2[i]);
            sumB += queue2[i];
        }

        while (index < maxCount) {
            if (sumA == sumB) {
                answer = index;
                break;
            }else if (sumA > sumB) {
                Integer temp = queA.poll();
                sumA -= temp;
                sumB += temp;
                queB.add(temp);
            }else if (sumB > sumA) {
                Integer temp = queB.poll();
                sumB -= temp;
                sumA += temp;
                queA.add(temp);
            }
            index++;
        }


        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] queue1, int[] queue2, int expect) {
        Assertions.assertThat(solution(queue1, queue2)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{3, 3, 3, 3},	new int[]{3, 3, 21, 3},	9),
                Arguments.of(new int[]{3, 2, 7, 2},	new int[]{4, 6, 5, 1},	2),
                Arguments.of(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2},	7),
                Arguments.of(new int[]{1, 1}, new int[]{1, 5},-1)
        );
    }
}
