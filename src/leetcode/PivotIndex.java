package leetcode;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int leftVal = 0;
        int sum = 0;

        for (int i=0; i<nums.length;i++) {
            sum += nums[i];
        }
        int rightVal = sum;

        for (int i=0; i<nums.length;i++) {
            if (i>=1) {
                leftVal += nums[i-1];
            }
            if (i <= nums.length-1) {
                rightVal -= nums[i];
            }
            if (leftVal == rightVal){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        PivotIndex pv = new PivotIndex();
        System.out.println(pv.pivotIndex(new int[]{2,1,-1}));
    }
}
