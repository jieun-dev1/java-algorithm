package leetcode;

public class Tribonacci {
    public int tribonacci(int n) {
        //1 base indexing
        int[] arr = new int[n+1];
        arr[0] = 0;
        if (n == 0) return arr[n];

        for (int i = 1; i <= n; i++ ){
            if (i <= 2) {
                arr[i] = 1;
                continue;
            }
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        return arr[n];
    }
}
