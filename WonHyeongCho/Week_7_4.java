import java.util.PriorityQueue;

/**
 * 제공자: Programmers
 * 제목: 디펜스게임
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/142085
 * 난이도: Level 2
 * 성공: 성공
 * 풀이완료시간: 60분/40분
 * 설명: 하.. 엄청 오래 걸릴 문제는 아닌데 너무 어렵게 생각했다. 사각지대 예외 잡기!!!
 */
public class Week_7_4 {

    public static void main(String[] args) {
//        int n = 7;
//        int k = 3;
//        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

//        int n = 2;
//        int k = 4;
//        int[] enemy = {3, 3, 3, 3};

        int n = 20;
        int k = 1;
        int[] enemy = {20, 20, 1};

        System.out.println(solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        if(k == enemy.length) return enemy.length;

        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while (n >= 0 && answer < enemy.length) {
            queue.add(enemy[answer]);

            n -= enemy[answer];

            if(n < 0 && k > 0) {
                n += queue.poll();
                k--;
            }

            answer++;
        }

        if(n >= 0) return answer;

        return answer-1;
    }


//    public static int solution(int n, int k, int[] enemy) {
//
////        if(k >= enemy.length) return enemy.length;
//
//        int answer = 0;
//
//        int index = 0;
//        int sum = 0;
//
//        while(sum < n) {
//            sum += enemy[index];
//            index++;
//        }
//
//        System.out.println("Index: " + index);
//
//        Set<Integer> targetSet = Arrays.stream(enemy, 0, index)
//                .map(number -> -number)
//                .sorted()
//                .map(number -> -number)
//                .limit(k)
//                .collect(HashSet::new, HashSet::add, HashSet::addAll);
//
//        System.out.println(Arrays.toString(targetSet.toArray()));
//
//        while(n > 0) {
//            if(k > 0 && targetSet.contains(enemy[answer])) {
//                k--;
//            } else {
//                n -= enemy[answer];
//            }
//
//            answer++;
//
//            if(answer == enemy.length) break;
//        }
//
//        return answer;
//    }
}
