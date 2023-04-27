import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 제공자: Programmers
 * 제목: 괄호 회전하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * 난이도: Level 2
 * 풀이완료시간: 20
 * 설명:
 */
public class Week_14_2 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
    }

    static int solution(String s) {
        int answer = 0;

        Set<Character> endBracketSet = Set.of(')', '}', ']');

        Queue<Character> bracketQueue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            bracketQueue.add(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i++) {

            if(i != 0) {
                bracketQueue.add(bracketQueue.poll());
            }

            Queue<Character> tempQueue = new LinkedList<>(bracketQueue);

            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < s.length(); j++) {

                char bracket = tempQueue.poll();

                if(!endBracketSet.contains(bracket)) {
                    stack.add(bracket);
                } else {
                    if(stack.isEmpty()) break;

                    char startBracket = stack.pop();

                    if(startBracket == '(' && bracket != ')') break;
                    if(startBracket == '{' && bracket != '}') break;
                    if(startBracket == '[' && bracket != ']') break;
                }

                if(j == s.length()-1 && stack.isEmpty()) answer++;
            }

        }

        return answer;
    }
}
