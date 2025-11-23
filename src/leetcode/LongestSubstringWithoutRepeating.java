package leetcode;

import jdk.jshell.EvalException;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> charLocation = new HashMap<>();
        int count = 0;
        int tempCount = 0;

        while (left <= right && right <= s.length() - 1) {
            Character current = s.charAt(right);
            //같은 원소일경우, left 의 위치를 갱신. left 까지의 count 가 1로 reset. 여기서 max 체크.
            if (charLocation.get(current) == null || charLocation.get(current) < left) {
                charLocation.put(current, right);
            } else  {
                count = Math.max(tempCount, count);
                tempCount -= (charLocation.get(current)-left+1);
                left = charLocation.get(current) + 1;
                charLocation.put(current, right);
            }
            tempCount ++;
            right++;
        }
        count = Math.max(tempCount, count);
        return count;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating ls = new LongestSubstringWithoutRepeating();
//        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(ls.lengthOfLongestSubstring("zabcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring(" "));


    }
}
