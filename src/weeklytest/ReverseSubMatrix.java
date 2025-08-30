package weeklytest;

import java.util.Arrays;

//when mid exists, mid is not
public class ReverseSubMatrix {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        //off is not the actual index. it's search index within the range,
        //other than the index, you should check separately
        for (int off = 0; off < k / 2; off++) {
            int r1 = x + off;
            int r2 = x + k - 1 - off;  // when x + k -1 it goes down to the bottom.
            for (int c = y; c < y + k; c++) {
                int temp = grid[r1][c];
                copy[r1][c] = grid[r2][c];
                copy[r2][c] = temp;
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        ReverseSubMatrix rs = new ReverseSubMatrix();
        int[][] grid = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] result = rs.reverseSubmatrix(grid, 1, 0, 3);
        System.out.println(result);
    }
}