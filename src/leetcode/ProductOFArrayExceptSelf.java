package leetcode;

import java.util.Arrays;

public class ProductOFArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];
        int[] output = new int[nums.length];
        prefixProducts[0] = nums[0];
        suffixProducts[nums.length-1] = nums[nums.length-1];

        for (int i=1; i<nums.length; i++) {
            prefixProducts[i] = nums[i]*prefixProducts[i-1];
            suffixProducts[nums.length-i-1] = nums[nums.length-i-1]*suffixProducts[nums.length-i];
        }
        System.out.println("prefixProducts:" + Arrays.toString(prefixProducts));
        System.out.println("suffixProducts:" + Arrays.toString(suffixProducts));

        for (int i=0;i<nums.length;i++) {
            if (i==0) {
                output[i] = suffixProducts[1];
            } else if (i == nums.length -1) {
                output[i] = prefixProducts[nums.length-2];
            } else {
                output[i] = prefixProducts[i-1] * suffixProducts[i+1];
            }
        }
        return output;
    }

}

class Main {

    public static void main(String[] args) {
        ProductOFArrayExceptSelf self = new ProductOFArrayExceptSelf();
        //int[] result = self.productExceptSelf(new int[]{1,2,3,4});
        int[] result = self.productExceptSelf(new int[]{-1,1,0,-3,3});

        System.out.println(Arrays.toString(result));
    }
}