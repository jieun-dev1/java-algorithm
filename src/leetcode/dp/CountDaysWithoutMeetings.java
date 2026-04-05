package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        //sort based on the start value
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int prevEnd = 0;
        int answer = 0;

        //Check front's empty days
        if (meetings[0][0] > 1) {
            answer += meetings[0][0] - 1;
        }
        for (int[] meeting:meetings){
            if (prevEnd != 0 && meeting[0] > prevEnd) {
                answer += (meeting[0] - prevEnd - 1);
            }
            prevEnd = Math.max(prevEnd, meeting[1]);
        }
        //Check end's empty days
        if (prevEnd < days) answer += (days - prevEnd);
        return answer;
    }
}
