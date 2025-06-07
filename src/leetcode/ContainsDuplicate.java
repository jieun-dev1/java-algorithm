package leetcode;
import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //key 가 존재한다면, 바로 return
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length;i++) {
            if (map.get(nums[i])!=null){
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;

    }
}
