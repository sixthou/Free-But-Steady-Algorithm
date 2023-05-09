/**
 * 제공자: Programmers
 * 제목: 문자열 나누기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/140108
 * 난이도: Level 1
 * 풀이완료시간:
 * 설명: 힘들다...
 */
public class Week_16_3 {

    public static void main(String[] args) {

        String s = "banana";
//        String s = "abracadabra";

        System.out.println(solution(s));
    }

    static public int solution(String s) {
        int answer = 0;

        char c = s.charAt(0);
        int count = 1;
        int unCharCount = 0;

        for(int i = 1; i < s.length(); i++) {

            if(count == 0) {
                c = s.charAt(i);
                count = 1;
                unCharCount = 0;
                continue;
            }

            if(c == s.charAt(i)) {
                count ++;
            } else {
                unCharCount++;
                if(count == unCharCount) {
                    count = 0;
                    answer++;
                }
            }
        }

        if(count != 0) answer++;

        return answer;
    }
}
