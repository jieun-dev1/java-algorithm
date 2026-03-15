package leetcode;

import java.util.*;
class BullsANdCows {
    //같은 위치 - 같은숫자
    public String getHint(String secret, String guess) {
        //secret, guess -> turns it into the digit and an array of it's location.
        //length = 1000. 1000 * 1000 = 1,000,000
        int bullCnt = 0;
        int cowCnt = 0;

        //"1807" 7811
        //7 {0} 8 {1} 1 {2,3}
        //7 {3} 8 {1} 1 {0} 0 {2}
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();


        for (int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bullCnt ++;
            secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
            guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
        }

        for (Character c: secretMap.keySet()) {
            int secretCnt = secretMap.getOrDefault(c, 0);
            int guessCnt = guessMap.getOrDefault(c, 0);
            cowCnt += Math.min(secretCnt, guessCnt);
        }
        cowCnt -= bullCnt;
        return bullCnt + "A" + cowCnt + "B";
    }
}
