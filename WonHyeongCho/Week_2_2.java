/**
 * 제공자: Programers
 * 제목: 푸드 파이트 대회
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * 난이도: 1
 * 풀이완료시간: -
 * 성공여부: 성공
 * 설명:
 * 예외:
 */
public class Week_2_2 {

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        StringBuilder halfAnswer = new StringBuilder();

        for(int i = 1; i < food.length; i++) {
            int half = food[i]/2;

            while(half > 0) {
                halfAnswer.append(i);
                half--;
            }
        }

        return answer.append(halfAnswer).append(0).append(halfAnswer.reverse()).toString();
    }
}
