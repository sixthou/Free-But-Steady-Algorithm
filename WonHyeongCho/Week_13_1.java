import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제공자: Programmers
 * 제목: 테이블 해시 함수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/147354
 * 난이도: Level 2
 * 풀이완료시간: 20분
 * 설명: 정렬을 먼저 진행해야 효율성 검사에 안걸린다. 그리고 나누는 숫자를 찾는것이 중요한데, 이것은 두 배열의 공통된 약수를 찾는것이다.
 */
public class Week_13_1 {

    public static void main(String[] args) {

    }

    static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        List<int[]> dataList = new ArrayList<>(Arrays.asList(data));

        dataList = dataList.stream().sorted((o1, o2) -> {
            if(o1[col-1] > o2[col-1]) {
                return 1;
            } else if(o1[col-1] < o2[col-1]) {
                return -1;
            } else {
                return o2[0] - o1[0];
            }
        }).collect(Collectors.toList());

        for(int i = row_begin-1; i < row_end; i++) {
            int[] element = dataList.get(i);

            int S_i = 0;
            for(int number : element) {
                S_i += (number % (i+1));
            }

            answer ^= S_i;
        }

        return answer;
    }
}
