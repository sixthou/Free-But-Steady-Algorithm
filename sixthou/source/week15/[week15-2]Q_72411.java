package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_72411 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 다른 사람의 풀이
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/72411
     * 난이도 : 2
     * 유형 : 조합
     * 설명 : 카카오 문제는 역시 오래걸린다. 순열 조합 연습 좀 해야할듯 계속 헛갈려서 많은 시간이 걸렸다.
     * 예외 :
     **/

    Map<String, Integer> picked = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        List<String> collect = Arrays.stream(orders)
                .map(s -> Arrays.stream(s.split("")).sorted().collect(Collectors.joining()))
                .collect(Collectors.toList());

        for (int dishSize : course) {
            for (String order : collect) {
                dfs(order, new boolean[order.length()], dishSize, "", 0);
            }
            answer.addAll(findAnswer());
            picked.clear();
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private void dfs(String str, boolean[] visited, int target, String temp, int index) {
        if (temp.length() == target) {
            picked.put(temp, picked.getOrDefault(temp, 0) + 1);
            return;
        }

        if (index > str.length() - 1) {
            return;
        }

        visited[index] = true;
        dfs(str, visited, target, temp + str.charAt(index), index + 1);
        visited[index] = false;
        dfs(str, visited, target, temp, index + 1);
    }

    private List<String> findAnswer() {
        int max = 2;
        Set<String> temp = new HashSet<>();

        for (String pick : picked.keySet()) {
            Integer size = picked.get(pick);
            if (size > max) {
                max = size;
                temp.clear();
                temp.add(pick);
            }
            if (size == max) {
                temp.add(pick);
            }
        }
        return new ArrayList<>(temp);
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] orders, int[] course, String[] expect) {
        Assertions.assertThat(solution(orders, course)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4}, new String[]{"WX", "XY"}),
                Arguments.of(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4}, new String[]{"AC", "ACDE", "BCFG", "CDE"}),
                Arguments.of(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5}, new String[]{"ACD", "AD", "ADE", "CD", "XYZ"})
        );
    }

    @Test
    void name() {
        dfs("abc", new boolean[3], 2, "", 0);
        picked.keySet().forEach(System.out::println);
    }
}
