package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> partitionString(String s) {
        List<String> answers = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            sb.append(c);
            if (!seen.contains(sb.toString())){
                seen.add(sb.toString());
                answers.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return answers;
    }
}
}
