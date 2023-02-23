/**
 * 제공자: Programmers
 * 제목: 거스름돈
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12907
 * 난이도: 3
 * 풀이완료시간: /30
 * 성공여부: 실패
 * 설명: DP, 점화식 문제. 이런 문제들은 직접 손으로 결과값을 그려보고 점화식을 찾아야 한다. 직접 해볼것!!!
 * 예외:
 */
public class Week_5_3 {

    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};

        System.out.println(solution(n, money));
    }

    /*
     * 점화식 풀이
     * 링크: https://tosuccess.tistory.com/57
     */
    private static int solution(int n, int[] money) {
        int[] answer = new int[1000001];
        answer[0] = 1;

        for(int i : money) {
            for(int j = i; j <= n; j++) {
                answer[j] += answer[j-i];
            }
        }

        return answer[n];
    }
}
