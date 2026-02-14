package review;

import java.util.*;




class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //Set<List<Integer>> 에 정렬해서 넣는다.
        Set<List<Integer>> answers = new HashSet<>();
        Arrays.sort(nums);
        int sum ;
        for (int i=0; i<nums.length -2; i++) {
            int left = i+1; //i가 포함되니까, 그 오른쪽 부터
            int right = nums.length - 1; //맨 끝까지.

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    answers.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++; //이미 left, right 조합은 나왔으니 가능한 조합은 무조건 left/right가 아니어야 함.
                    right --;
                } else if (sum < 0) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return new ArrayList<>(answers);
    }
}
