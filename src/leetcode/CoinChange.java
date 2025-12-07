package leetcode;

import java.util.Arrays;

public class CoinChange {
//    입력: coins = [1,2,3,5,6,9,10,11,13,14], amount = 2000
//    출력: 143
    public int coinChange(int[] coins, int amount) {
        //28 - 14*2 일수도 있고, 14+13+1 일수도 있고, 조합으로 못만들수도 있음.
        //amount 가 적은것부터 쌓아올리면서, 과거 내용 기반으로 찾기.
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //amount 도달 전까지, dp 배열 갱신
        dp[0] = 0;
        for (int i=1; i<amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // dp[0] = 0이고, dp[1]에서 1을 빼면, dp[0] 이므로 1으로 재할당.
                        //dp[i-coins[j]+1 can be overflowed. which will be -2147483648
                    }
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        //int[] coins = new int[]{1,2,3,5,6,9,10,11,13,14};
        //int amount = 2000;
        int[] coins = {2};
        int amount = 3;

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
    }
}
