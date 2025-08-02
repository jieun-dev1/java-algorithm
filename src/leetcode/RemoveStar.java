package leetcode;

import java.util.Stack;

public class RemoveStar {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveStar removeStar = new RemoveStar();
        System.out.println(removeStar.removeStars("leet**cod*e"));

    }

}
