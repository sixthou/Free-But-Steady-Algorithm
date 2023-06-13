import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 제공자: Programmers
 * 제목: 시소 짝꿍
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 난이도: Level 2
 * 풀이완료시간:
 * 설명:
 */
public class Week_21_2 {

    public static void main(String[] args) {
        int[] weights = {1, 1, 3, 3, 3, 4, 4, 5};
        System.out.println(solution(weights));
    }

    static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights) {
            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }

        return answer;
    }
}
