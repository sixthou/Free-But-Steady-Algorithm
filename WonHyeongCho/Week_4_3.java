import java.util.*;

/**
 * 제공자: Programmers
 * 제목: 보석 쇼핑
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * 난이도: 3
 * 풀이완료시간: 50/30
 * 성공여부: 실패
 * 설명: 문제를 잘못 이해했다. 가장 짧은 구간을 구해야 하는데...
 *      슬라이딩 윈도우 방식으로 해결
 * 예외:
 */
public class Week_4_3 {

    public static void main(String[] args) {

//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = {"A", "B", "C", "D", "E"};

        String[] gems = {"A", "B", "B", "B", "C", "D", "D", "D", "D", "D", "D", "D", "B", "C", "A"};

        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        long gemTypeCount = Arrays.stream(gems).distinct().count();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, L = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int R = 0; R < gems.length; R++) {
            map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);

            while (map.get(gems[L]) > 1) {
                map.put(gems[L], map.get(gems[L]) - 1);
                L++;
            }

            if (map.size() == gemTypeCount && length > (R - L)) {
                length = R - L;
                answer[0] = L + 1;
                answer[1] = R + 1;
            }
        }

        return answer;
    }
}
