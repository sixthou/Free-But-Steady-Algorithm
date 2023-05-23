package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_42586 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 기능개발
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42586
     * 난이도 : 2
     * 유형 : 큐
     * 설명 :
     * 예외 :
     **/

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] +1));
        }

        int index = 1;
        Integer front = queue.poll();

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if (now > front) {
                answer.add(index);
                index = 1;
                front = now;
                continue;
            }
            index++;
        }

        answer.add(index);

        return answer.stream().mapToInt(s->s).toArray();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] progresses, int[] speeds, int[] expect) {
        Assertions.assertThat(solution(progresses, speeds)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{93, 30, 55}, new int[]{1, 30, 5}, new int[]{2, 1}),
                Arguments.of(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 3, 2})
        );
    }

}
