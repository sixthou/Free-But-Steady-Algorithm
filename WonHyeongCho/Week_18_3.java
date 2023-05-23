import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: n^2 배열 자르기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 난이도: Level 2
 * 풀이완료시간: 25
 * 설명: 규칙을 알면 쉽게 푼다. 규칙을 빨리 아는것이 중요.
 */
public class Week_18_3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }

    static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        int index = 0;
        for(long i = left; i <= right; i++) {
            answer[index] = Math.max((int) (i / n), (int) (i % n)) + 1;
            index++;
        }

        return answer;
    }
    // 실패 메모리 초과
//    static int[] solution(int n, long left, long right) {
//        StringBuilder sb = new StringBuilder();
//
//        long length = 0;
//
//        for(int i = 1; i <= n; i++) {
//            for(int j = 1; j <= n; j++) {
//                sb.append(Math.max(j, i));
//
//                length++;
//
//                if(length == left) {
//                    sb.delete(0, sb.length());
//                } else if(length == right + 1) {
//                    i = n + 1;
//                    break;
//                }
//            }
//        }
//
//        return Arrays.stream(sb.toString().split("")).mapToInt(Integer::parseInt).toArray();
//    }
}
