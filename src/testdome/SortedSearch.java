package testdome;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int left = 0;
        int right = sortedArray.length - 1;
        int mid = 0;
        int answer = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sortedArray[mid] >= lessThan) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (answer == mid) {
            answer += 1;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 9));
    }

}