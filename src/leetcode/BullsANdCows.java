package leetcode;

import java.util.*;

class BullsANdCows {

    public String getHint(String secret, String guess) {
        int[] arr = new int[10]; // Track remaining digit counts from secret (excluding bulls)

        int bullCnt = 0;
        int cowCnt = 0;

        // First pass: count bulls and record digit frequencies from secret
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            char g = guess.charAt(i);

            if (c == g) {
                bullCnt++;
            } else {
                arr[c - '0']++;
            }
        }

        // Second pass: count cows using the remaining digit frequencies
        for (int i = 0; i < guess.length(); i++) {
            char c = secret.charAt(i);
            char g = guess.charAt(i);

            if (c != g) {
                // Decrease count only if the digit still exists in secret.
                // This ensures cows are counted only up to the number of occurrences in secret.
                if (arr[g - '0'] > 0) {
                    arr[g - '0']--;
                    cowCnt++;
                }
            }
        }

        return bullCnt + "A" + cowCnt + "B";
    }
}
