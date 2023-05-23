import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: k진수에서 소수 개수 구하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * 난이도: Level 2
 * 풀이완료시간: 40
 * 설명: 레벨 2에서 이렇게 오래 걸리다니.. 런타임 에러 조심! int 형 범위 초과, 소수 구하는 공식 외워두는게 좋을듯
 */
public class Week_18_2 {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
//        System.out.println(solution(1000, 2));
//        System.out.println(solution(1000, 10));
//        System.out.println(solution(11000, 10));
//        System.out.println(solution(200, 3));
        System.out.println(solution(341257, 10));
    }

    static int solution(int n, int k) {
        int answer = 0;

        String converted = conversion(n, k);


        String[] nums = Arrays.stream(converted.split("0")).filter(s -> !s.equals("")).toArray(String[]::new);

        for (String num : nums) {
            if (isPrime(Long.parseLong(num))) {
                answer++;
            }
        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < converted.length(); i++) {
//
//            String s = String.valueOf(converted.charAt(i));
//
//            if(s.equals("0")) {
//                String numStr = sb.toString();
//
//                if(sb.length() > 0 && isPrime(Integer.parseInt(numStr))) {
//                    System.out.println("numStr: " + numStr);
//                    answer++;
//                }
//
//                sb.delete(0, sb.length());
//            } else {
//                sb.append(s);
//            }
//        }
//
//        if(sb.length() > 0 && isPrime(Integer.parseInt(sb.toString()))) {
//            System.out.println("last: " + sb);
//            answer++;
//        }

        return answer;
    }

    static String conversion(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % k;
            n /= k;
            sb.append(remainder);
        }

        return sb.reverse().toString();
    }

    static boolean isPrime(long n) {
        if(n == 1) return false;

        if(n == 2 || n == 3) return true;

        for(int i = 2; i < Math.sqrt(n)+1; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
