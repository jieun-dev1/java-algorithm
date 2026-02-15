package leetcode.graph;

import java.util.*;

class LargeIsland {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    List<int[]> locationOfZeros = new ArrayList<>();


    public int largestIsland(int[][] grid){
        //island size by index
        Map<Integer, Integer> islandSize = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();

        int index = 2;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    locationOfZeros.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    grid[i][j] = index;
                    queue.add(new int[]{i, j});
                    islandSize.put(index, bfs(queue, index++, grid));
                }
            }
        }

        int maxSize = 0;

        for (int i=0; i<locationOfZeros.size(); i++) {
            int[] element = locationOfZeros.get(i);
            Set<Integer> ids = new HashSet<>();
            for (int j=0; j<4; j++) {
                int nx = element[0] + dx[j];
                int ny = element[1] + dy[j];

                if (nx < 0 || nx > grid.length - 1 || ny < 0 || ny > grid[0].length - 1) {
                    continue;
                }

                if (grid[nx][ny]!= 0) {
                    ids.add(grid[nx][ny]);
                }
            }
            int currentSize = 0;
            for(int id : ids) {
                currentSize += islandSize.get(id);
            }
            //including the changing cell itself.
            maxSize = Math.max(currentSize+1, maxSize);
        }

        if (locationOfZeros.isEmpty()) {
            maxSize = grid.length * grid[0].length;
        }
        return maxSize;
    }

    public int bfs(Queue<int[]> queue, int id, int[][] grid) {
        int size = 1;
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = element[0] + dx[i];
                int ny = element[1] + dy[i];
                if (nx < 0 || nx > grid.length-1 || ny < 0 || ny > grid[0].length -1) {
                    continue;
                }
                if (grid[nx][ny] == 0) {
                    locationOfZeros.add(new int[]{nx, ny});
                    continue;
                }
                if (grid[nx][ny] == 1) {
                    grid[nx][ny] = id;
                    queue.offer(new int[]{nx, ny});
                    size++;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        LargeIsland largeIsland = new LargeIsland();
        int[][] grid = new int[][]{{1,1},{1,1}};
        System.out.println(largeIsland.largestIsland(grid));
    }
}
