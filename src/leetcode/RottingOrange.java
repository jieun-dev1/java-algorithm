package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {
    //check oranges to be rotten/already rotten
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<grid.length;i++) {
            for (int j=0; j<grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    freshCount ++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        return bfs(grid, freshCount, queue);
    }

    //multi bfs : 여러 시작점 중 가장 가까운 거리.
    public int bfs(int[][] grid, int freshCount, Queue<int[]> queue) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int changedCount = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int second = 0;
        if (freshCount == 0) return second;

        while (!queue.isEmpty()) {
            int queueSize = queue.size(); // if queue.size() is in the for loop, what's added in queue during for loop will be added in that level.
            for (int i = 0; i < queueSize; i++) {
                int[] rotten = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + rotten[0];
                    int ny = dy[j] + rotten[1];
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || visited[nx][ny]) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        changedCount++;
                        visited[nx][ny] = true;  //make sure visited!
                        queue.offer(new int[]{nx, ny});
                    }
                }
           }
            second++;
            if (freshCount == changedCount) {
                return second;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RottingOrange ro = new RottingOrange();
        //System.out.println(ro.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(ro.orangesRotting(new int[][]{{2,1,1},{1,1,1},{0,1,2}}));
    }

}
