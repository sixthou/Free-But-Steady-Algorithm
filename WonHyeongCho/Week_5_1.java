import java.util.*;

/**
 * 제공자: Programmers
 * 제목: 튜플
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/64065
 * 난이도: 2
 * 풀이완료시간: 25/30
 * 성공여부: 성공
 * 설명: 나는 이런 문제에 대해 약한 것 같다. 논리적으로 생각할때 너무 복잡하게 생각하는 듯
 * 그리고 반복문에서 String 을 계속 생성해서 메모리 초과 발생함
 * 예외:
 */
public class Week_5_1 {

    public static void main(String[] args) {
//        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s = "{{2},{1,2,3},{2,1},{2,4,1,3},{2,4,1,7,3},{2,4,7,1,9,3}}";

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        String[] split = Arrays.stream(s.substring(1, s.length() - 2).split("},"))
                .map(str -> str.substring(1))
                .sorted(Comparator.comparing(String::length))
                .toArray(String[]::new);

        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(split[0]));

        for(int i = 1; i < split.length; i++) {
            String[] subSplit = split[i].split(",");

            for (String value : subSplit) {
                if (!list.contains(Integer.parseInt(value))) {
                    list.add(Integer.parseInt(value));
                    break;
                }
            }
        }

        return list.stream().mapToInt(number -> number).toArray();
    }
}
