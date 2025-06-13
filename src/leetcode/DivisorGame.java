package leetcode;

public class DivisorGame {
    public boolean solution(int n) {
        boolean[] dp = new boolean[n+1]; //n번 째에서 앨리스가 이기는 여부
        dp[0] = false;
        dp[1] = true;
        for (int i=2;i<n+1;i++){
            for (int k=1;k<i;k++) {
                if (i%k == 0 && !dp[i-k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
