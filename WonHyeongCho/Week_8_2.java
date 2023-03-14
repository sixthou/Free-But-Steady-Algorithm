import java.util.Arrays;
import java.util.Map;

/**
 * 제공자: Programmers
 * 제목: 시소 짝꿍
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 난이도: Level 2
 * 풀이완료시간: 30분
 * 설명: 최대공약수를 구할때 유클리드 호제 사용 --> 이해는 안되지만 코드는 쉬어서 외워버리자, 근데 최대공약수 문제가 아니었음;; 최소 공배수!!
 *      완전이진탐색 문제 풀이도 있음
 */
public class Week_8_2 {

    public static void main(String[] args) {
//        int[] weights = {100, 100, 100, 100, 200, 270, 300, 400};

        int[] weights = {100, 100, 100, 200, 200, 200, 270, 300, 400};

        System.out.println(solution(weights));
    }

    static long solution(int[] weights) {
        long[] dp = new long[weights.length];

        Arrays.sort(weights);

        for(int i = 0; i < weights.length-1; i++) {
            int weight = weights[i];
            long count = 0;

            if(i != 0 && weight == weights[i-1]) {
                dp[i] = dp[i-1]-1;
                continue;
            }

            for(int j = i+1; j < weights.length; j++) {
                int nextWeight = weights[j];

                long LCM = (long) weight * nextWeight / getGCD(weight, nextWeight);

                System.out.println("A: " + weight + ", B: "+ nextWeight + ", LCM: " + LCM);

                if(LCM / weight <= 4 && LCM / nextWeight <= 4) {
                    System.out.println("IN");
                    count++;
                }
            }

            dp[i] = count;
        }

        long answer = 0;

        for(long data : dp) {
            answer += data;
        }

        return answer;
    }

    static int getGCD(int a, int b) {
        if (b == 0) return a;
        else return getGCD(b, a % b);
    }
}
