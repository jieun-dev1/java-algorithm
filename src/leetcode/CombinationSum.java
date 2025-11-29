package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new StringBuilder(), 0, 0, k, 0, n);
        return result;
    }

    public void dfs(StringBuilder digits, int currentIndex, int currentLength, int length, int currentSum, int sum) {
        if (length == currentLength) {
            if (currentSum == sum) {
                result.add(digits.chars().map(c -> c - '0').boxed().collect(Collectors.toList()));
            }
            return;
        }
        for (int i=currentIndex+1; i<=9; i++) {
            if (currentSum + i > sum ) {
                return;
            }
            dfs(digits.append(i), i, currentLength + 1, length, currentSum + i, sum);
            digits.deleteCharAt(digits.length()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int k = 3;
        int n = 9;
        System.out.println(combinationSum.combinationSum3(k, n));
    }
}
