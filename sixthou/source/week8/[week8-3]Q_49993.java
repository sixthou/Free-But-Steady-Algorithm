package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_49993 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 스킬트리
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/49993#fnref1
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 예외처리 확실하게
     * 예외 :
     **/

    public int solution(String skill, String[] skill_trees) {
        ArrayList<String> skills = (ArrayList<String>) Arrays.stream(skill.split(""))
                .collect(Collectors.toList());
        return Arrays.stream(skill_trees)
                .mapToInt(skill_tree -> cal((ArrayList<String>) skills.clone(), skill_tree))
                .sum();
    }


    private int cal(ArrayList<String> skills, String skillTree) {
        for (int i = 0; i < skillTree.length(); i++) {
            if (skills.contains(skillTree.substring(i, i + 1))) {
                if (!skills.get(0).equals(skillTree.substring(i, i + 1))) {
                    return 0;
                }
                skills.remove(0);
            }
        }
        return 1;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String skill, String[] skill_trees, int expect) {
        Assertions.assertThat(solution(skill, skill_trees)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("B", new String[]{"C"}, 1),
                Arguments.of("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}, 2),
                Arguments.of("CBD", new String[]{"B"}, 0),
                Arguments.of("ABC", new String[]{"DEF"}, 1),
                Arguments.of("ABC", new String[]{"BCA"}, 0)
        );
    }
}
