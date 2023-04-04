import java.util.Stack;

/**
 * 제공자: Programmers
 * 제목: 올바른 괄호
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 난이도: Level 2
 */
public class Week_11_1 {

    public static void main(String[] args) {

        String s = "()()";

        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
