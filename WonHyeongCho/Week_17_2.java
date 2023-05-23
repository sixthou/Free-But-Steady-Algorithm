import java.util.stream.Stream;

/**
 * 제공자: Programmers
 * 제목: 조이스틱
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * 난이도: Level 2
 * 풀이완료시간:
 * 설명: 쭉 가는것보다 짧은 경로를 선택해야 하는 문제
 */
public class Week_17_2 {

    public static void main(String[] args) {
        Stream.of(
                "JEROEN",
                "JAN",
                "JAZ",
                "AAAAA",
                "AABAAAAAAABBB"
        ).forEach(name -> System.out.println(solution(name)));
    }

    static int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }

    // 실패
//    static int solution(String name) {
//        int answer = 0;
//
//        int[] distances = new int[name.length()];
//
//        for(int i = 0; i < name.length(); i++) {
//            distances[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
//        }
//
//        answer += distances[0];
//
//        if(distances[1] == 0) {
//            for(int i = distances.length - 1; i > 1; i--) {
//                answer = answer + distances[i] + 1;
//            }
//        } else {
//            for(int i = 1; i < distances.length; i++) {
//                if(i == distances.length - 1 && distances[i] == 0) {
//                    break;
//                }
//                answer = answer + distances[i] + 1;
//            }
//        }
//
//        return answer;
//    }
}
