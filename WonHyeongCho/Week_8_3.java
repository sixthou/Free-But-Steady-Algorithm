import java.util.Arrays;
import java.util.*;

/**
 * 제공자: Programmers
 * 제목: 구명보트
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * 난이도: Level 2
 * 풀이완료시간: 10분
 * 설명: 2진 탐색으로는 실패, 그리디 알고리즘인데 음.. 최적으로 안뽑아도 되는거지??
 */
public class Week_8_3 {

    public static void main(String[] args) {
//        int[] people = {70, 50, 80, 50};
//        int limit = 100;

        int[] people = {70,  80, 50};
        int limit = 100;

//        int[] people ={100, 100, 100, 100, 200, 270, 300, 400};
//        int limit = 800;

        System.out.println(solution(people, limit));
    }

    static int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        for(int x : people) list.add(x);
        Collections.sort(list);

        // 꼭 사이즈 지정 필요
        ArrayDeque<Integer> dq = new ArrayDeque<>(50505);
        dq.addAll(list);

        int ans = 0;
        while(!dq.isEmpty()) {
            int weight = dq.pollLast();
            if(!dq.isEmpty() && weight + dq.peekFirst() <= limit) { dq.pollFirst(); }
            ans++;
        }

        return ans;
    }

//    static int solution(int[] people, int limit) {
//        int answer = 0;
//
//        Arrays.sort(people);
//
//        int[] check = new int[people.length];
//
//        for(int i = people.length-1; i > 0; i--) {
//            if(check[i] == 1) continue;
//
//            int index = bs(people, check, limit - people[i], 0, i-1);
//
//            if(index != -1) {
//                check[index] = 1;
//            }
//
//            check[i] = 1;
//            answer++;
//        }
//
//        if(check[0] == 0) answer++;
//
//        return answer;
//    }
//
//    static int bs(int[] people, int[] check, int subtractLimit, int start, int end) {
//
//        System.out.println("Start: " + start + ", End: " + end);
//
//        if(start == end) {
//            if(people[start] <= subtractLimit) return start;
//            else return -1;
//        }
//
//        int mid = Math.floorDiv(start + end, 2);
//
//        System.out.println("Mid: " + mid + ", Size: " + people[mid]);
//
//        if(people[mid] >= subtractLimit) {
//            if(check[mid] == 1) {
//                return bs(people, check, subtractLimit, start, mid-1);
//            }
//            else {
//                return bs(people, check, subtractLimit, start, mid);
//            }
//        }
//        else {
//            return bs(people, check, subtractLimit, mid+1, end);
//        }
//    }
}