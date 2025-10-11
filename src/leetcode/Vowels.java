package leetcode;

import jdk.jshell.EvalException;

import java.util.Arrays;

public class Vowels {
    public int maxVowels(String s, int k) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int kVowelCnt = 0;
        int maxCount = 0;

        for (int i = 0; i < k; i++) {
            boolean isCurrentVowel = new String(vowels).indexOf(s.charAt(i)) >= 0;
            if (isCurrentVowel) {
                kVowelCnt++;
            }
        }
        maxCount = Math.max(maxCount, kVowelCnt);

        for (int i = k; i < s.length(); i++) {
            boolean isCurrentVowel = new String(vowels).indexOf(s.charAt(i - k)) >= 0;
            boolean isNextVowel = new String(vowels).indexOf(s.charAt(i)) >= 0;

            if (isCurrentVowel) {
                kVowelCnt--;
            }
            if (isNextVowel) {
                kVowelCnt++;
            }
            maxCount = Math.max(maxCount, kVowelCnt);
        }

        return maxCount;

    }
    public static void main(String[] args) {
        Vowels vowels = new Vowels();
        //System.out.println(vowels.maxVowels("leetcode", 3));
        System.out.println(vowels.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
    }
}