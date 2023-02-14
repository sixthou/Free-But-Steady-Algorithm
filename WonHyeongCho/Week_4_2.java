import java.util.*;
import java.util.stream.Collectors;

/**
 * 제공자: Programmers
 * 제목: 할인 행사
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * 난이도: 2
 * 풀이완료시간: 40/30
 * 성공여부: 성공
 * 설명: want 에 있는 항목들을 모두 살수있는 총 일수, 코드가 좀 지저분하게 짜여졌다....
 * 예외:
 */
public class Week_4_2 {

    public static void main(String[] args) {

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

//        String[] want = {"banana", "apple", "rice"};
//        int[] number = {5, 2, 3};
//        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "apple", "apple", "banana", "rice", "rice", "rice", "banana", "apple"};

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Queue<String> sales = new LinkedList<>(Arrays.asList(discount).subList(0, 10));

        Map<String, Integer> maps = sales.stream().collect(Collectors.toMap(product -> product, product -> 1, Integer::sum));

        for(int i = 10; i <= discount.length; i++) {
            for(int j = 0; j < want.length; j++) {
                Integer count = maps.get(want[j]);
                if(count == null || count != number[j]) break;

                if(j == want.length-1) answer++;
            }

            if(i == discount.length) break;

            String pastProduct = sales.poll();
            maps.put(pastProduct, maps.get(pastProduct)-1);
            sales.add(discount[i]);

            if(maps.containsKey(discount[i])) {
                maps.put(discount[i], maps.get(discount[i])+1);
            }
            else {
                maps.put(discount[i], 1);
            }
        }

        return answer;
    }

}