package leetcode;

public class PrefixSum {
        public int largestAltitude(int[] gain) {
            int[] altitude = new int[gain.length+1];
            int maxValue = 0;
            for (int i=1; i<altitude.length;i++){
                altitude[i] = altitude[i-1] + gain[i-1];
                maxValue = Math.max(altitude[i], maxValue);
            }
            return Math.max(0, maxValue);
        }
}
