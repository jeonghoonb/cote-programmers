package stackAndQueue;

import java.util.Stack;

/*
    올바른 괄호 (https://school.programmers.co.kr/learn/courses/30/lessons/12909)
    문자열 s가 올바른 괄호이면 true, 아니면 false

    input:
        - "()()"
    output:
        - answer = true
 */
public class No_12909 {

    String s = "(())()";
    char left = '(';
    char right = ')';
    boolean answer = false;

    public void solution() {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (right == c) {
                    answer = false;
                    break;
                } else {
                    stack.add(c);
                }
            } else {
                if (stack.peek() == c) {
                    stack.add(c);
                } else {
                    stack.pop();
                }
            }
        }

        answer = stack.isEmpty();

        System.out.println(answer);
    }


}
