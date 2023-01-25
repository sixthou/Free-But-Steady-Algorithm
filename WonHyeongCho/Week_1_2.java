/**
 * 제공자: Programers
 * 제목: 문자열 숫자 변환
 * URL:
 * 난이도: 1
 * 풀이완료시간: -
 * 성공여부: 성공
 * 설명: 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 * 제한 조건
 * s의 길이는 1 이상 5이하입니다.
 * s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 * s는 부호와 숫자로만 이루어져있습니다.
 * s는 "0"으로 시작하지 않습니다.
 *
 */
public class Week_1_2 {
    public static void main(String[] args) {

        String s = "+5421";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer;

        if(s.startsWith("+")) {
            answer = Integer.parseInt(s.substring(1));
        }
        else if (s.startsWith("-")) {
            answer = Integer.parseInt(s.substring(1)) * -1;
        }
        else {
            answer = Integer.parseInt(s);
        }

        return answer;
    }
}