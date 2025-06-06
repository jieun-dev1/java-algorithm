package dynamicProgramming;

//New Year Gift Challenge - 2
public class BestTImeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = prices[0];
        for (int i=1; i<prices.length;i++) {
            int currentPrice = prices[i];
            if (currentPrice > lowestPrice){
                profit = Math.max(currentPrice - lowestPrice, profit);
            }
            lowestPrice = Math.min(lowestPrice, currentPrice);
        }
        return profit;
    }
}
