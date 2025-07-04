package leetcode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        for (int i=min;i<word1.length();i++)  {
            sb.append(word1.charAt(i));
        }

        for (int i=min; i< word2.length();i++) {
            sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}