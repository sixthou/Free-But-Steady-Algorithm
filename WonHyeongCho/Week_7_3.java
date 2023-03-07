/**
 * 제공자: Programmers
 * 제목: 다음 큰 숫자
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12911
 * 난이도: Level 2
 * 풀이완료시간: 10분
 * 설명:
 */
public class Week_7_3 {

    public static void main(String[] args) {

        int n = 78;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = n+1;

        int nBitCount = Integer.bitCount(n);

        while(nBitCount != Integer.bitCount(answer)) answer++;

        return answer;
    }
}
