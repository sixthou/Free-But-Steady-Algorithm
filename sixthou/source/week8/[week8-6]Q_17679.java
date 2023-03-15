package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17679 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 프렌즈4블록
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17679
     * 난이도 : 2
     * 유형 : 단순구현
     * 설명 : 카카오블로그 해설에 난이도가 상으로 나와있지만 실상은 단순구현 문제 귀찮아서 그렇지 어렵지는 않았다.
     * 예외 :
     **/

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        List<List<String>> boards = Arrays.stream(board)
                .map(s -> Arrays.stream(s.split("")).collect(Collectors.toList())).collect(Collectors.toList());
        int tmp = 0;
        do {
            tmp = findEqual(m, n, boards);
            answer += tmp;
        } while (tmp != 0);
        return answer;
    }

    private static int findEqual(int m, int n, List<List<String>> board) {
        int[][] map = new int[m][n];
        int tmp = 0;
        //find
        for (int i = m - 1; i >= 1; i--) {
            for (int j = 0; j < n -1; j++) {
                if (!Objects.equals(board.get(i).get(j), "") &&
                    Objects.equals(board.get(i).get(j), board.get(i).get(j + 1)) &&
                    Objects.equals(board.get(i).get(j), board.get(i - 1).get(j + 1)) &&
                    Objects.equals(board.get(i).get(j), board.get(i - 1).get(j))
                ) {
                    map[i][j] = map[i][j + 1] = map[i - 1][j] = map[i - 1][j + 1] = 1;
                }
            }
        }

        //erase
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    board.get(i).set(j, "");
                    tmp++;
                }
            }
        }

        //compress
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board.get(i).get(j).equals("")) {
                    for (int k = i - 1 ; k >= 0; k--) {
                        if (!board.get(k).get(j).equals("")) {
                            board.get(i).set(j, board.get(k).get(j));
                            board.get(k).set(j, "");

                            break;
                        }
                    }
                }
            }
        }


        return tmp;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int m, int n, String[] board, int expect ) {
        Assertions.assertThat(solution(m, n, board)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(4,	5,	new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"},	14),
                Arguments.of(6,	6,	new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"},	15)
        );
    }
}
