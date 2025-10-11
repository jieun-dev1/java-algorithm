package leetcode;

import java.util.Set;

public class Vowels {
    public int maxVowels(String s, int k) {

        int kVowelCnt = 0;
        int maxCount = 0;

        for (int i = 0; i < k; i++) {
            char current = s.charAt(i);
            if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
                kVowelCnt++;
            }
        }
        maxCount = Math.max(maxCount, kVowelCnt);

        for (int i = k; i < s.length(); i++) {
            char current = s.charAt(i-k);
            char next = s.charAt(i);
            if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
                kVowelCnt--;
            }

            if (next == 'a' || next == 'e' || next == 'i' || next == 'o' || next == 'u') {
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