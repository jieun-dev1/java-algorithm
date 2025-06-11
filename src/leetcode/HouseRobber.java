package leetcode;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] maxNums = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        maxNums[0] = nums[0];
        maxNums[1] = nums[1];
        for (int i=2; i<nums.length;i++) {
            if (i>=3) {
                maxNums[i] = Math.max(
                        Math.max(
                                maxNums[i-3]+nums[i],
                                maxNums[i-2]+nums[i]
                        ),maxNums[i-1]);
            } else {
                maxNums[i] = Math.max(maxNums[i-2]+nums[i], maxNums[i-1]);
            }
        }
        return maxNums[nums.length-1];
    }
}
