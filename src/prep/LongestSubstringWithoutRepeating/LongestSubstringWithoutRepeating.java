package prep.LongestSubstringWithoutRepeating;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int solution(String s){
        //current
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int right = 0;
        //abcabcbb
        int max = 0;
        for (int i=right; i<s.length(); i++) {
            //charSet에서 해당 char 가질경우
            while (charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(left));
                left ++;
            }
            //가지질 않을 경우
            charSet.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
