package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_67258 {
    /**
     * 제공자 : 프로래머스
     * 제목 : 보석쇼핑
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/67258
     * 난이도 : 3
     * 유형 : 투포인터
     * 설명 : 처음 문제를 보고 어떻게 풀지 전혀 감이 안잡혔다. 한참을 보다가 다른 사람들의 힌트를 보고 풀게됨. 투포인터... 부분합을 구하는 문제에서 유용하다고 한다. 잘 정리해둬야지.
     * 예외 :
     **/

    public int[] solution(String[] gems) {
        int head = 0;
        int tail = 0;
        int answerHead = 0;
        int answerTail = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        while (true) {
            while (set.size() == map.size()) {
                if (tail - head < answerTail - answerHead) {
                    answerTail = tail;
                    answerHead = head;
                }
                if (map.get(q.peek()) == 1) {
                    break;
                }
                if (map.get(q.peek()) > 1) {
                    head++;
                    map.put(q.peek(), map.get(q.peek()) - 1);
                    q.poll();
                }
            }

            if (tail == gems.length) {
                break;
            }

            String nowGem = gems[tail];
            map.put(nowGem, map.getOrDefault(nowGem, 0) + 1);
            q.add(nowGem);
            tail++;
        }

        return new int[]{answerHead + 1, answerTail};
    }







    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] gems, int[] expect) {
        Assertions.assertThat(solution(gems)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}, new int[]{1, 5}),
                Arguments.of(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}, new int[]{3, 7}),
                Arguments.of(new String[]{"AA", "AB", "AC", "AA", "AC"}, new int[]{1, 3}),
                Arguments.of(new String[]{"XYZ", "XYZ", "XYZ"}, new int[]{1, 1})
        );
    }
}
