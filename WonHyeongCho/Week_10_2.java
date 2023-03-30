import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 제공자: Programmers
 * 제목: 롤케이크 자르기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * 난이도: Level 2
 * 풀이완료시간: 20분
 * 설명: 간단한 그리드 알고리즘
 */
public class Week_10_2 {

    public static void main(String[] args) {


        List<int[]> parameters = new ArrayList<>();
        parameters.add(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        parameters.add(new int[]{1, 4, 3, 2, 3, 1, 3, 3, 5, 4});
        parameters.add(new int[]{1, 1});
        parameters.add(new int[]{3, 3, 3, 3});
        parameters.add(new int[]{3, 3, 2, 2, 3, 3, 2, 2});

        parameters.forEach(element -> System.out.println(solution(element)));
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> left = Arrays.stream(topping)
                .boxed()
                .collect(HashMap::new, (map, key) -> map.merge(key, 1, Integer::sum), HashMap::putAll);
        Map<Integer, Integer> right = new HashMap<>();

        for(int i = topping.length-1; i > 0; i--) {
            int number = topping[i];

            Integer count = left.get(number);

            System.out.println(System.identityHashCode(left.get(number)));
            System.out.println(System.identityHashCode(count));

            if(count == 1) {
                left.remove(number);
            } else {
                left.put(number, count-1);
            }

            right.merge(number, 1, Integer::sum);

            System.out.println("Left: " + Arrays.toString(left.keySet().toArray()));
            System.out.println("Right: " + Arrays.toString(right.keySet().toArray()));

            if(isFare(left, right)) answer++;
        }

        return answer;
    }

    static boolean isFare(Map a, Map b) {
        long aKeyCount = a.keySet().size();
        long bKeyCount = b.keySet().size();

        return aKeyCount == bKeyCount;
    }
}
