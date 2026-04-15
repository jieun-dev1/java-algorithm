package prep.mergeIntervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergedIntervals {
    // intervals = [[1,3],[2,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {

        //원소 정렬
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>(); //we can't estimate the size yet.
        int[] current = intervals[0]; //track the last element of the merged (list)
        merged.add(current);
        for (int i=1; i<intervals.length; i++) {
            //previous[1] >=  현재 순회의 첫자리 여야, Merge
            //[1,3], [2,6] -> [1,6]
            if (current[1] >= intervals[i][0]) {
                //[1,4], [2,3] -> [1,4]
                current[1] = Math.max(intervals[i][1], current[1]);
                merged.remove(merged.size()-1); //마지막의 원소 빼고
                merged.add(current); //업데이트 된 애로 다시더해.
            } else {
                merged.add(intervals[i]);
                current = intervals[i];
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }

}