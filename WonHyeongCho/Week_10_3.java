import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: 등굣길
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * 난이도: Level 3
 * 풀이완료시간: 40분
 * 설명: 장애물이 있을 때 최단 경로 구하기 문제, 동적 계획법, 탑 다운, 바텀 업 방식으로 풀이
 * 효율성 테스트 실패 -> 허들 찾는 함수를 만들지 말고 dp에 바로 표시, 계산하다 보면 int 범위거 넘어갈 수 있음
 */
public class Week_10_3 {

    public static void main(String[] args) {

        int m = 4; int n = 3; int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }

    static int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n+2][m+2];
        dp[n][m] = 1;

        for(int[] puddle: puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        // Bottom Up 방식
        for(int i = m; i > 0; i--) {
            for (int j = n; j >0; j--) {

                if (dp[j][i] < 0) {
                    continue;
                }

                if(i == m && j == n) continue;

                int right = dp[j][i + 1];
                int down = dp[j + 1][i];

                if(right > 0) dp[j][i] += right;
                if(down > 0) dp[j][i] += down;
                dp[j][i] %= 1000000007;

                for(int[] data: dp) {
                    System.out.println(Arrays.toString(data));
                }

                System.out.println();
            }
        }

        return dp[1][1];
    }
}
