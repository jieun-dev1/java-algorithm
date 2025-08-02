package leetcode;

import java.util.Stack;

public class RemoveStar {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
            sb.reverse();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveStar removeStar = new RemoveStar();
        System.out.println(removeStar.removeStars("leet**cod*e"));

    }

}
