package leetcode;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int prefixSum = 0;
        int startIndex = 0;
        int endIndex = k-1;
        int maxSum = 0;

        for (int i=0; i<k; i++) {
            prefixSum += nums[i];
        }
        maxSum = prefixSum; //don't have to compare.

        while (endIndex< nums.length-1) {
            prefixSum -= nums[startIndex];
            startIndex ++;
            endIndex ++;
            prefixSum += nums[endIndex];
            maxSum = Math.max(maxSum, prefixSum);
        }
        return (double) maxSum / k;
    }
}
