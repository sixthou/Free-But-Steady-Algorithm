import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: 혼자 놀기 달인
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/131130
 * 난이도: Level 2
 * 풀이완료시간: 20분
 * 설명: 완전 탐색 문제, 완전 탐색 문제는 느낌이 완전탐색을 안하면 못풀거같은 느낌이다.
 */
public class Week_12_1 {

    public static void main(String[] args) {
        int[] cards = new int[]{8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        int answer = 0;

        for(int i = 0; i < cards.length; i++) {
            boolean[] flags = new boolean[cards.length];
            int first = visit(i, cards, flags);
            int second = 0;

            for(int j = 0; j < cards.length && !flags[j]; j++) {
                second = Math.max(visit(j, cards, Arrays.copyOf(flags, flags.length)), second);
            }

            answer = Math.max(first * second, answer);
        }

        return answer;
    }

    static int visit(int start, int[] cards, boolean[] flags) {
        int count = 1;
        flags[start] = true;
        int next = cards[start];

        while(!flags[next-1]) {
            count++;
            flags[next-1] = true;
            next = cards[next-1];
        }

        return count;
    }
}
