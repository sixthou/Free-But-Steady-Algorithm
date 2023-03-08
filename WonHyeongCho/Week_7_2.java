import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: 이모티콘 할인행사
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/150368
 * 난이도: Level 2
 * 풀이완료시간: 40/40
 * 결과: 실패
 * 설명: 어떻게 이게 레벨 2문제지??? 카카오 블라인드 테스트 너무 어렵다... 나는 머리가 나쁜걸까
 */
public class Week_7_2 {

    public static void main(String[] args) {

        int[][] users = {
                {40, 2900},
                {23, 10000},
                {11, 5200},
                {5, 5900},
                {40, 3100},
                {27, 9200},
                {32, 6900}
        };

        int[] emoticons = {1300, 1500, 1600, 4900};

        System.out.println(Arrays.toString(solution(users, emoticons)));
    }

    public static int[] solution(int[][] users, int[] emoticons) {

        int[] answer = new int[2];
        int[] discountRate = {10, 20, 30, 40};

        Arrays.sort(users);

        int maxSigner = 0;

        for(int[] user: users) {



        }


        Arrays.stream(users).forEach(user -> {
            System.out.println(Arrays.toString(user));
        });

        return answer;
    }
}
