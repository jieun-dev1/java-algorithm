package prep.MaxConsecutiveOnes;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int answer = 0;
        //find the longest subarray which contains at most k 0's
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                //check the current char and move the left cursor.
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            System.out.println("left: " + left + "right: " + right);
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
