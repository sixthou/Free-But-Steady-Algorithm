import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 제공자: Programmers
 * 제목: 호텔 대실
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 난이도: Level 2
 * 풀이완료시간: 그리디 문제
 * 설명:
 */
public class Week_21_1 {

    public static void main(String[] args) {
        String[][] book_time = {
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"},
        };

        System.out.println(solution(book_time));
    }

    static int solution(String[][] book_time) {
        int time[][] = new int[book_time.length][2];

        for(int i =0;i<book_time.length;i++){
            int startTime = Integer.parseInt(book_time[i][0].replace(":",""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":",""));

            endTime += 10;
            if(endTime%100 >= 60){
                endTime+=40;
            }
            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for(int[] timeTemp : time){
            if(queue.size() == 0){
                queue.add(timeTemp[1]);
                continue;
            }
            if((queue.peek()) <= timeTemp[0]){
                queue.poll();
                queue.add(timeTemp[1]);
            }else{

                queue.add(timeTemp[1]);
            }
        }

        return queue.size();
    }
}
