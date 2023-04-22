package FreeButSteedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 제공자: Programmers
 * 제목: 숫자 카드 나누기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * 난이도: Level 2
 * 풀이완료시간: 20분
 * 설명: 이분 탐색 문제 이다. min 과 max 를 정의하는것이 애매하다. 블로그에 있는 해석도 좀...
 */
public class Week_13_2 {

    public static void main(String[] args) {
        int[] arrayA = new int[]{14, 35, 119};
        int[] arrayB = new int[]{18, 30, 102};

        System.out.println(solution(arrayA, arrayB));
    }

    static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        List<Divisor> divisorList = new ArrayList<>();
        addDivisors(0, arrayA, divisorList);
        addDivisors(1, arrayB, divisorList);

        divisorList.sort((o1, o2) -> o2.number - o1.number);

        for (Divisor divisor : divisorList) {
            if (divisor.type == 0) {
                if (isNotDivisor(arrayB, divisor.number)) {
                    answer = divisor.number;
                    break;
                }
            } else {
                if (isNotDivisor(arrayA, divisor.number)) {
                    answer = divisor.number;
                    break;
                }
            }
        }

        return answer;
    }

    static boolean isNotDivisor(int[] array, int divisor) {
        for(int number : array) {
            if(number % divisor == 0) return false;
        }

        return true;
    }

    static void addDivisors(int type, int[] array, List<Divisor> divisorList) {
        for(int i = 2; i <= array[0]; i++) {

            boolean flag = true;
            for(int number : array) {
                if(number % i != 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) divisorList.add(new Divisor(i, type));
        }
    }

    static class Divisor {
        int number;
        int type;

        public Divisor(int number, int type) {
            this.number = number;
            this.type = type;
        }
    }
}
