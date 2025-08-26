package leetcode;

public class NumOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]&&grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(grid, visited, r-1, c);
        dfs(grid, visited, r, c-1);
        dfs(grid, visited, r, c+1);
        dfs(grid, visited, r+1, c);
    }
}
