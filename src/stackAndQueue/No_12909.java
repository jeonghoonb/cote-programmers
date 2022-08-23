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
        useArray();
        useStack();
    }

    private void useStack() {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (right == c) {
                    answer = false;
                    break;
                }
                stack.add(c);
            } else {
                if (stack.peek() == c) {
                    stack.add(c);
                }
                stack.pop();
            }
        }

        answer = stack.isEmpty();

        System.out.println(answer);
    }

    private void useArray() {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                count++;
            }

            if (')' == s.charAt(i)) {
                count--;
            }

            if (count < 0) {
                break;
            }
        }

        System.out.println(count == 0);
    }


}
