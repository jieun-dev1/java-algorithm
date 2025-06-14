package leetcode;

import java.util.*;

/**
 * HashSet 은 순서 보장 하지 안는다. queue 에서 원소 뽑을 때마다, String 을 새로 만들어줘야 한다.
 */
public class CountSortedVowelStrings {

    Map<String, Integer> order = new HashMap<>(); //현재 키의 순서
    int answer = 0;
    String[] vowels = {"a","e","i","o","u"};
    int[][] memo;

    public int countVowelStrings(int n) {
        memo = new int[n+1][5]; // cases. length - startIndex (현재 선택 가능한 모음의 시작 인덱스)
        for (int[] row: memo) Arrays.fill(row, -1);
        return dfs(n, 0);
    }
    //if there's no memoization, dfs until it returns and count the sum
    public int dfs(int remainingLength, int startIndex) {
        if (remainingLength == 0) return 1;

        if (memo[remainingLength][startIndex]!=-1) {
            return memo[remainingLength][startIndex];
        }

        int count = 0;

        for (int i=startIndex;i<5;i++) {
            count += dfs(remainingLength-1, i);
        }
        memo[remainingLength][startIndex] = count;
        return count;
    }


    public static void main(String[] args) {
        CountSortedVowelStrings st = new CountSortedVowelStrings();
        System.out.println(st.countVowelStrings(33));
    }
}


