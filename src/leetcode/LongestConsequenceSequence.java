package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsequenceSequence {
        public int longestConsecutive(int[] nums) {
            Set<Integer> hashSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            List<Integer> numList = new ArrayList<>(hashSet);
            Collections.sort(numList);
            int answer = 0;
            int left = 0;
            int right = 0;

            if (nums.length == 0) return 0;

            for (int i=1; i<numList.size(); i++) {
                if (numList.get(i) == numList.get(i-1)+1) {
                    right = i;
                } else {
                    answer = Math.max(answer, right - left + 1);
                    left = i;
                    right = i;
                }
            }
            return Math.max(answer, right - left + 1);
        }
}
