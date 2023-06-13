/**
 * 제공자: Programmers
 * 제목: 기사 단원의 무기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * 난이도: Level 1
 * 풀이완료시간:
 * 설명:
 */
public class Week_21_3 {

    public static void main(String[] args) {
        System.out.println(solution(10, 3, 2));
    }

    static int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {

            int count = 0;

            for(int j = 1; j*j <= i; j++) {
                if(j * j == i) count ++;
                else if(i % j == 0) count += 2;
            }

            answer += count > limit ? power : count;
        }

        return answer;
    }
}
