/**
 * 제공자: Programers
 * 제목: 크기가 작은 부분 문자열
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java
 * 난이도: 1
 * 풀이완료시간: -
 * 성공여부: 성공
 * 설명: 문자열 t 중에서 부분 문자열 중 p 보가 크거나 작은 경우
 * 예외: 부분 문자열이 long 자료형이 될 수 있다.
 */
public class Week_2_1 {

    public static void main(String[] args) {
//        String t = "3141592";
//        String p = "271";

//        String t = "10203";
//        String p = "15";

        String t = "10201245511020124551";
        String p = "1020124551";

        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int answer = 0;

        long pNumber = Long.parseLong(p);
        int pLength = p.length();

        for(int i = 0; i + pLength <= t.length(); i++) {
            long subNumber = Long.parseLong(t.substring(i, i + pLength));
            if(pNumber >= subNumber) answer++;
        }

        return answer;
    }
}
