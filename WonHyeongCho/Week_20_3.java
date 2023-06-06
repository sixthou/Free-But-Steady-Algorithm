import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 제공자: Programmers
 * 제목: 스킬 트리
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/49993
 * 난이도: Level 2
 * 풀이완료시간:
 * 설명:
 */
public class Week_20_3 {

    public static void main(String[] args) {
//        String skill = "CBD";
//        String skill_trees[] = {"BACDE", "CBADF", "AECB", "BDA"};
        String skill = "CBD";
        String skill_trees[] = {"C", "B", "D"};
        System.out.println(solution(skill, skill_trees));
    }

    static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Map<Character, Integer> orderMap = new HashMap<>();

        for(int i = 0; i < skill.length(); i++) {
            orderMap.put(skill.charAt(i), i);
        }

        Stack<Character> skillStack = new Stack<>();

        for(int i = 0; i < skill_trees.length; i++) {
            for(int j = 0; j < skill_trees[i].length(); j++) {
                if(orderMap.containsKey(skill_trees[i].charAt(j))) {

                    if(orderMap.get(skill_trees[i].charAt(j)) == 0) {
                        skillStack.push(skill_trees[i].charAt(j));
                    } else {
                        if(skillStack.isEmpty()) {
                            break;
                        }

                        int order = orderMap.get(skill_trees[i].charAt(j));
                        int stackOrder = orderMap.get(skillStack.peek());

                        if(order - 1 != stackOrder) {
                            break;
                        }
                        else {
                            skillStack.push(skill_trees[i].charAt(j));
                        }
                    }
                }

                if(j == skill_trees[i].length() - 1) {
                    answer++;
                }
            }
            skillStack.clear();
        }

        return answer;
    }
}
