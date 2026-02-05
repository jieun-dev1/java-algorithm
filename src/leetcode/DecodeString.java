package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        Stack<String[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder countSb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                countSb.append(ch);
                continue;
            }

            if (ch == '[') {
                // (prefix, countString) 저장
                stack.push(new String[]{sb.toString(), countSb.toString()});
                // 다음 블록을 위해 초기화
                sb.setLength(0);
                countSb.setLength(0);
                continue;
            }

            if (ch == ']') {
                String[] prior = stack.pop();
                String prefix = prior[0];
                int count = Integer.parseInt(prior[1]); // Integer.valueOf 제거
                String repeated = sb.toString().repeat(count);
                // prefix + repeated 로 갱신
                sb.setLength(0);
                sb.append(prefix).append(repeated);
                continue;
            }

            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String answer = decodeString.decodeString("2[a2[b2[z]]]");
        System.out.println(answer);
    }
}
