package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12913 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 땅따먹기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12913
     * 난이도 : 2
     * 유형 : DP
     * 설명 : 완탐으로 풀어보려다 시간초과로 실패. DP로 풀어서 성공. 순열, 조합 알고리즘 연습했던게 도움이 됨
     * 예외 :
     **/
/*
    int max = 0;

    int solution(int[][] land) {
        func(land, 0, -1, new ArrayList<>());
        return max;
    }

    void func(int[][] land, int depth, int index, List<Integer> peek) {
        if (peek.size() == land.length) {
            System.out.println(peek);
            max = Math.max(max, peek.stream().reduce(0, Integer::sum));
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i != index) {
                peek.add(land[depth][i]);
                func(land, depth + 1, i, peek);
                peek.remove(peek.size() - 1);
            }
        }
    }*/

    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = func(dp[i - 1], j) + land[i][j];
            }
        }

        return func(dp[land.length - 1], -1);
    }

    int func(int[] map, int index) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (i != index) {
                temp = Math.max(temp, map[i]);
            }
        }
        return temp;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] land, int expect) {
        Assertions.assertThat(solution(land)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 99}, {4, 3, 2, 1}}, 106),
                Arguments.of(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}, 16)
        );
    }
}
