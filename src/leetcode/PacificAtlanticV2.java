package leetcode;

import java.util.*;

public class PacificAtlanticV2 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0,-1,0, 1}; //북, 서, 남, 동

    public void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for (int i=0; i<4; i++) {
                int nx = node[0]+dx[i];
                int ny = node[1]+dy[i];
                //(3,1) -> (3,0) 같은 케이스도 존재하므로, nx 나 ny 가 0일때도 허용.
                if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length) {
                    if (!visited[nx][ny] && (heights[nx][ny]>=heights[node[0]][node[1]])) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //방문 여부 확인
        boolean[][] pacificVisited = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVisited = new boolean[heights.length][heights[0].length];
        //가장 자리는 모두 queue 에 들어간다.
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        int r = heights.length;
        int c = heights[0].length;

        for (int i=0; i<r; i++){
            pacificQueue.offer(new int[]{i, 0});
            pacificVisited[i][0] = true;
            atlanticQueue.offer(new int[]{i, c-1});
            atlanticVisited[i][c-1] = true;
        }
        for (int i=0; i<c; i++) {
            pacificQueue.offer(new int[]{0, i});
            pacificVisited[0][i] = true;
            atlanticQueue.offer(new int[]{r-1,i});
            atlanticVisited[r-1][i] = true;
        }

        bfs(heights, pacificQueue, pacificVisited);
        bfs(heights, atlanticQueue, atlanticVisited);

        List<List<Integer>> answers = new ArrayList<>();

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    answers.add(Arrays.asList(i, j));
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PacificAtlanticV2 pa = new PacificAtlanticV2();
        List<List<Integer>> answers = pa.pacificAtlantic(heights);
        System.out.println(answers);
    }
}
