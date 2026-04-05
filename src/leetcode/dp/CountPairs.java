package leetcode.dp;

//3185 - DP
//space - O(1) time - O(N)
public class CountPairs {
    public long countCompleteDayPairs(int[] hours) {
        //check if remainder's sum %24 = 0
        int[] count = new int[24];
        long answer = 0; //pair can be n*(n-1)/2. as n is 10^9, it can be overflow.
        for (int i=0; i<hours.length; i++) {
            //1
            int current = hours[i] % 24;

            //23
            int mod = (24 - current) % 24;
            //how many modes are now. like.. if there are two of 1, then (1,23) (1,23)
            answer += count[mod];
            count[current]++;
        }
        return answer;
    }
}
