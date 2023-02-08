package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12981 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 영어 끝말잇기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12981
     * 난이도 : 2
     * 설명 : 구현
     * 예외 :
     **/

    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        Set<String> set = new HashSet<>();
        char last = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (last != words[i].charAt(0) || set.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            last = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, String[] words, int[] expect) {
        Assertions.assertThat(solution(n, words)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}, new int[]{3,3}),
                Arguments.of(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}, new int[]{0,0}),
                Arguments.of(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}, new int[]{1,3})
        );
    }
}
