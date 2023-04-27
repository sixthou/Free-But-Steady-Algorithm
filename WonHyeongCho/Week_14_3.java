/**
 * 제공자: Programmers
 * 제목: 모음 사전
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * 난이도: Level 2
 * 풀이완료시간: 20
 * 설명:
 */
public class Week_14_3 {

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }

    static int solution(String word) {
        int answer = 0;
        int[] base = {781, 156, 31, 6, 1};
        for (int i = 0; i < word.length(); i++) {
            int idx = "AEIOU".indexOf(word.charAt(i));
            answer += idx * base[i] + 1;
        }
        return answer;
    }
}
