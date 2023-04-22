package FreeButSteedy;

/**
 * 제공자: Programmers
 * 제목: 마법의 엘레베이터
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 난이도: Level 2
 * 풀이완료시간: 45분
 * 설명: 와.. 예외가 너무 많아 이런문제에 시간을 많이 뺏기는거 같다. 나는 모든 경의수를 생각해서 풀었는데... BFS, DFS 문제였네?
 *      다른 사람들 풀이 엄청나다...
 */
public class Week_13_3 {

    public static void main(String[] args) {
//        int storey = 2554;
//        int storey = 1000000000;
//        int storey = 1000001000;
//        int storey = 2341111;
//        int storey = 8833198;
        int storey = 5555;
//        int storey = 999999999;
        System.out.println(solution(storey));
    }

    static int solution(int storey) {
        int answer = 0;

        String storeyString = Integer.toString(storey);

        int up = 0;
        int number = 0;
        for(int i = 0; i < storeyString.length(); i++) {
            number = Character.getNumericValue(storeyString.charAt(storeyString.length()-i-1)) + up;

            System.out.print("Number: " + number);

            if(number == 10) {
                System.out.println();
                continue;
            }

            if(number < 5) {
                answer += number;
                up = 0;
            } else if(number == 5) {
                answer += 5;

                if(i != storeyString.length()-1) {
                    int nextNumber = Character.getNumericValue(storeyString.charAt(storeyString.length()-i-2));

                    if(nextNumber < 5) up = 0;
                    else up = 1;
                }
            }
            else {
                answer += (10 - number);
                up = 1;

                if(i == storeyString.length()-1) number = 10;
            }

            System.out.println(", Answer: " + answer);
        }

        if(number == 10) answer += 1;

        System.out.println();

        return answer;
    }
}
