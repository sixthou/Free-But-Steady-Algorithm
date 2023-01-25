import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 제공자: Programers
 * 제목: 중복 숫자 제거
 * URL: https://programmers.co.kr/skill_checks/455808
 * 난이도: 1
 * 풀이완료시간: -
 * 성공여부: 성공
 * 설명: [1,1,3,3,0,1,1] --> [1, 3, 0, 1]
 *
 */
public class Week_1_1 {
    public static void main(String[] args) {

        int[] numberArray = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(solution(numberArray)));
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int preNumber = 10;
        for(int number : arr) {
            if(preNumber != number) list.add(number);
            preNumber = number;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
