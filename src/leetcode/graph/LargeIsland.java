package leetcode.graph;

import java.util.*;

class LargeIsland {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int largestIsland(int[][] grid) {
        //island size by index
        Map<Integer, Integer> islandSize = new HashMap<>();

        int index = 2;
        int maxResult = 0;
        //n*n
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //do the dfs to find the size of island
                    int result = find(i, j, index, grid);
                    //mark the island with unique index
                    islandSize.put(index, result);
                    index ++;
                    //in case there's no 0
                    maxResult = Math.max(maxResult, result);
                }
            }
        }

        //0의 위치 찾아서 그 가운데에 있는 0 flip 시 4방향 중 unique 한 애들만 더하기.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visited = new HashSet<>();
                    int connectedSize = 1;
                    for (int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        //방문한 적 있다면 넘긴다.
                        if ( nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1 || grid[nx][ny] == 0 || visited.contains(grid[nx][ny])) { continue; }
                        connectedSize += islandSize.get(grid[nx][ny]);
                        //make sure to check as visited
                        visited.add(grid[nx][ny]);
                    }
                    maxResult = Math.max(connectedSize, maxResult);
                }
            }
        }
        return maxResult;
    }
    //get the size of island
    public int find(int x, int y, int index, int[][] grid) {
        int n = grid.length;

        if (x < 0 || x > n - 1 || y < 0 || y > n  - 1) {
            return 0;
        }
        if (grid[x][y] != 1) {
            return 0;
        }

        int cnt = 1;
        //must be here before visiting 4 dir. unless one of four dir will visit the one calls it
        grid[x][y] = index;

        cnt += find(x + dx[0], y+ dy[0], index,  grid);
        cnt += find(x + dx[1], y+ dy[1], index,  grid);
        cnt += find(x + dx[2], y+ dy[2], index,  grid);
        cnt += find(x + dx[3], y+ dy[3], index,  grid);

        return cnt;
    }

}
