package leetcode;

import java.util.HashMap;
import java.util.Map;

class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numOccurence = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numOccurence.put(nums[i], numOccurence.getOrDefault(nums[i], 0)+1);
            // 1 - [1,2], 2 - [1]
        }
        int count = 0;
        // for (int num: numOccurence.keySet()) {
        //keyset 으로 순회 가능한가?

        for (int num : nums) {

            if (numOccurence.getOrDefault(num, 0) >= 1 && (numOccurence.getOrDefault(k-num, 0) >= 2 && num == k-num || numOccurence.getOrDefault(k - num, 0) >= 1 && num != k-num)) {
                numOccurence.put(k - num, numOccurence.get(k - num) - 1);
                //num, k-num will be removed. I put wrong one at first  which is k
                numOccurence.put(num, numOccurence.get(num)-1);
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
//        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
//        int k = 2;
//        int[] nums = {1,2,3,4};
//        int k = 5;
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;

        System.out.println(maxOperations.maxOperations(nums, k));
    }
}
