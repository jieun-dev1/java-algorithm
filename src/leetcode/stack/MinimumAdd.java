package leetcode.stack;

import java.util.Stack;

class MinimumAdd {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }
}
