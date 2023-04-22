package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_154538 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 숫자 변환하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/154538
     * 난이도 : 2
     * 유형 : bfs
     * 설명 : 메모라이징을 추가한 bfs
     * 예외 : dfs로 시작했다가 시간 초과로 bfs + 메모라이징으로 변경
     **/


    public int solution(int x, int y, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node nNode = queue.poll();
            int nNow = nNode.now;
            int depth = nNode.depth;

            if (map.containsKey(nNow)) {
                continue;
            }

            if (nNow > y) {
                continue;
            }

            map.put(nNow, depth);

            queue.add(new Node(nNow + n, depth + 1));
            queue.add(new Node(nNow * 2, depth + 1));
            queue.add(new Node(nNow * 3, depth + 1));
        }

        return map.getOrDefault(y, -1);
    }


    class Node {
        int now;
        int depth;

        public Node(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int x, int y, int n, int expect) {
        Assertions.assertThat(solution(x, y, n)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(10, 40, 5, 2),
                Arguments.of(10, 40, 30, 1),
                Arguments.of(2, 5, 4, -1)
        );
    }
}
