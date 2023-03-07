/**
 * 제공자: Programmers
 * 제목: 덧칠하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/161989
 * 난이도: Level 2
 * 풀이완료시간: 10분
 * 설명: 새로운 문제라 풀어봤는데 그냥 단순한 문제였다.
 */
public class Week_7_1 {

    public static void main(String[] args) {

        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int current = 1;

        for(int i = 0; i < section.length; i++) {
            if(current <= section[i]) {
                current = section[i] + m;
                answer++;
            }
        }

        return answer;
    }
}
