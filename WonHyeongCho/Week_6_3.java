/**
 * 제공자: Programers
 * 제목: 카펫
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42842
 * 난이도: Level 2
 * 풀이완료시간: 12분
 * 설명:
 */
public class Week_6_3 {
    public static void main(String[] args) {
        int[] answer = solution(10, 2);
        for(int num : answer) {
            System.out.println(num);
        }
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalCarpets = brown + yellow;

        int row = 0;
        int col = 0;

        for(int i = 3; i < Math.sqrt(totalCarpets); i++) { // 약수 찾기, 1, 2는 제외
            if(totalCarpets%i == 0) { // 약수 일 경우
                row = i;
                col = totalCarpets/i;

                if((2*row+2*col-4 == brown)) {// 테투리의 개수가 갈색의 갯수
                    break;
                }
            }
        }

        if(row >= col) {
            answer[0] = row;
            answer[1] = col;
        }
        else {
            answer[0] = col;
            answer[1] = row;
        }

        return answer;
    }
}
