/**
 * 제공자: Programmers
 * 제목: 점 찍기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/140107
 * 난이도: 2
 * 풀이완료시간: 20/30
 * 성공여부: 성공
 * 설명:  1사분면 원 안에 있는 점 찾기, 루트 d제곱 - a제곱 >= b 이경우를 찾으면 됨.
 * 예외:
 */
public class Week_6_1 {

    public static void main(String[] args) {
        int k = 2;
        int d = 4;

        System.out.println(solution(k, d));
    }

    private static long solution(int k, int d) {
        long answer = 0;

        for(int i = 0; i <= d;  i += k) {
            long powD = (long)d*d;
            long powI = (long)i*i;
            int top = (int)Math.sqrt(powD - powI);
            answer += (top/k) + 1;
        }

        return answer;
    }
}
