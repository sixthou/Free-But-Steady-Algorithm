import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 제공자: Programmers
 * 제목: 추억 점수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * 난이도: Level 1
 * 풀이완료시간:
 * 설명: 시간이 없어 레벨 1 문제로 풉니다.. 죄송...
 */
public class Week_20_2 {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> scoreMap = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int score = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if(scoreMap.containsKey(photo[i][j])) {
                    score += scoreMap.get(photo[i][j]);
                }
            }

            answer[i] = score;
        }

        return answer;
    }
}
