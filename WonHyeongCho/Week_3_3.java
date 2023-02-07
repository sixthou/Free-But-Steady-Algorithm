import java.util.*;

/**
 * 제공자: Programmers
 * 제목: 캐시
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/17680
 * 난이도: 2
 * 풀이완료시간: 50/30
 * 성공여부: 성공
 * 설명: LRU 캐시 구현... LinkedHashMap 객체 사용, LinkedList 만 써도 됨... 너무 어렵게 생각했다.
 * 예외:
 */
public class Week_3_3 {

    public static void main(String[] args) {


        int cacheSize = 30;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Seoul", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

//        int cacheSize = 0;
//        String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"};


//        int cacheSize = 5;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Deque<String> cache = new LinkedList<>();
        Stack<String> tmpSpace = new Stack<>();

        if(cacheSize == 0) {
            return cities.length*5;
        }

        for (String s : cities) {
            String upperS = s.toUpperCase();
            if (cache.contains(upperS)) {
                while (!cache.isEmpty()) {
                    String city = cache.poll();
                    if (city.equals(upperS)) {
                        break;
                    } else {
                        tmpSpace.push(city);
                    }
                }

                while (!tmpSpace.isEmpty()) cache.addFirst(tmpSpace.pop());

                answer += 1;
            } else {
                if(cache.size() == cacheSize) cache.poll();
                answer += 5;
            }

            cache.add(upperS);
        }

        return answer;
    }
}