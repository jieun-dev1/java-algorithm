package leetcode;

import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    Map<String, List<String>> map = new HashMap<>();
    List<String> answers = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        dfs(digits, 0, "");
        return answers;
    }

    public void dfs(String digits, int index, String current){
        if (index == digits.length()) {
            if (current!="")
                answers.add(current);
            return;
        } //unless outofboudns in the below code
        List<String> numbers = map.get(digits.substring(index, index+1)); //numbers of the
        for (int i=0; i<numbers.size(); i++) {
            String newStr = numbers.get(i);
            StringBuilder str = new StringBuilder(current).append(newStr);
            dfs(digits, index+1, str.toString());
        }
    }
}