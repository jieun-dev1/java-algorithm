package leetcode;

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int left= 0;
        int right = nums.length - 1;
        //5,0,1,2,3,4 | T : 5

        while (left <= right) {
            //1. l:0 r:5 m = 2
            //2. l:0 r: 1 m= 0;
            int mid = (left + right)/2; //)left + (right - left)/2
            if (nums[mid] == target) {
                return mid;
            }

            //1. 5 <= 1
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                //1.1 <= 5 && 5 <= 4 (x)
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    //1. right = 2-1 = 1
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}