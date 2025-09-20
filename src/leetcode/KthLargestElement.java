package leetcode;

import com.sun.source.tree.IfTree;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k-1];
    }

    public void quickSort(int[] nums, int start, int end) {
        //make sure not to put 0 & nums.length -1 in start
        int part2 = partition(nums, start, end);
        if (start < part2 -1) {
//        if (part2 > start - 1) {
            quickSort(nums, start, part2 - 1);
        }
        if (part2 < end) {
            quickSort(nums, part2, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[(start + end) / 2];
        while (start <= end) {
            while (nums[start] > pivot) start++;
            while (nums[end] < pivot) end--;
            if (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public void swap(int[] nums,int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int answer = kthLargestElement.findKthLargest(nums, k);
        System.out.println(answer);

    }

}
