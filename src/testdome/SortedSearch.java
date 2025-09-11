package testdome;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
           int mid = (left + right) / 2;
            if (sortedArray[mid] >= lessThan) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }



    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 2, 3, 5, 7 }, 1));
        System.out.println(SortedSearch.countNumbers(new int[] { 2, 3, 5, 7 }, 9));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 2, 5, 7 }, 4));
    }

}