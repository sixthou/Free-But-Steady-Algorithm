import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: 이진 변환 반복하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * 난이도: 2
 * 풀이완료시간: 10/30
 * 성공여부: 성공
 * 설명:
 * 예외:
 */
public class Week_3_1 {

    public static void main(String[] args) {

//        String s = "110010101001";
        String s = "01110";

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {

        int number = 0;
        int zeroCount = 0;
        int count = 0;

        StringBuilder sb = new StringBuilder(s);

        while(number != 1) {
            int preLength = sb.length();
            String processed = sb.toString().replaceAll("0", "");
            zeroCount = zeroCount + (preLength - processed.length());
            number = processed.length();
            sb.delete(0, sb.length());
            sb.append(Integer.toBinaryString(processed.length()));
            count++;
        }

        return new int[]{count, zeroCount};
    }
}