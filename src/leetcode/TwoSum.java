package leetcode;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numIndexes = new HashMap<>();
        int[] answer = new int[2];

        for (int i=0; i<nums.length; i++) {
            int current = nums[i];
            List<Integer> values = numIndexes.getOrDefault(current, new ArrayList<Integer>());
            values.add(i);
            numIndexes.put(current, values); //현재 자신의 값과 array 에서의 위치
        }
        for (int i=0; i<nums.length; i++) {
            int current = nums[i];
            int targetRemainder = target - current;
            //2를 넘지않을 것으로 예상
            if (current == targetRemainder) {
                if (numIndexes.get(targetRemainder).size() >= 2) {
                    answer = numIndexes.get(targetRemainder).stream().mapToInt(Integer::intValue).toArray();
                    return answer;
                }
            } else {
                List<Integer> targetRemainderValues = numIndexes.get(targetRemainder);
                if (targetRemainderValues!=null & !targetRemainderValues.isEmpty()) {
                    answer[0] = i;
                    answer[1] = targetRemainderValues.get(0);
                    return answer;
                }
            }
        }
        return answer;

    }
}