/**
 * 제공자: Programmers
 * 제목: JadenCase 문자열 만들기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * 난이도: 2
 * 풀이완료시간: 15/30
 * 성공여부: 성공
 * 설명:
 * 예외:
 */
public class Week_5_2 {

    public static void main(String[] args) {
        String s = "3people unFollowed me";

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append(Character.toString(s.charAt(0)).toUpperCase());

        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.charAt(i-1) == ' ') {
                sb.append(Character.toString(c).toUpperCase());
            }
            else {
                sb.append(Character.toString(c).toLowerCase());
            }
        }

        return sb.toString();
    }
}
