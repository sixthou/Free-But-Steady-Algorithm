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
 * 설명: 문제가 처음에 이해하기 어려웠음, 예제 보니 쉬었다... Sorting 오름차순과 내림차순의 기준이 뭘까..?
 */
public class Week_12_2 {

    public static void main(String[] args) {
        int[][] data = new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;

        System.out.println(solution(data, col, row_begin, row_end));
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

        for(int[] e : dataList) System.out.println(Arrays.toString(e));

        for(int i = row_begin-1; i < row_end; i++) {
            int[] element = dataList.get(i);

            int S_i = 0;
            for(int number : element) {
                S_i += (number % (i+1));
            }

            System.out.println("answer: " + answer + ", S_i: " + S_i + ", answer ^ S_i: " + (answer ^ S_i));

            answer ^= S_i;
        }

        return answer;
    }
}
