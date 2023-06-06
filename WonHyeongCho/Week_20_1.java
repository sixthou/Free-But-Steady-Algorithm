import java.util.HashSet;
import java.util.Set;

/**
 * 제공자: Programmers
 * 제목: 연속 부분 수열 합의 개수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 난이도: Level 2
 * 풀이완료시간:
 * 설명: 바보같이 어렵게 생각하지말고 단순히 생각하자
 */
public class Week_20_1 {

    public static void main(String[] args) {
        int[] arr = {7,9,1,1,4};
        System.out.println(solution(arr));
    }

    static int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        for(int i = 0; i < elements.length; i++) {
            int sum = elements[i];
            int currnet = i;
            sums.add(sum);

            for(int j = 1; j < elements.length; j++) {
                currnet = (currnet + 1) % elements.length;
                sum += elements[currnet];
                sums.add(sum);
            }
        }

        return sums.size();
    }
}
