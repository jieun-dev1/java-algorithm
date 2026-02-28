package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDup {
    //handling two adjacent === only check the pair (two )
        public String removeDuplicates(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            stack.push(s.charAt(0));

            for (int i=1; i<s.length(); i++) {
                if (stack.isEmpty()){
                    stack.push(s.charAt(i));
                    continue;
                }
                char last = stack.peek();

                if (last != s.charAt(i)) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }
            // deque's head is the stack's top
            char[] answers = new char[stack.size()];

            for (int i=stack.size()-1; i>=0; i--) {
                answers[i] = stack.pop();
            }
            return new String(answers);
        }
}
