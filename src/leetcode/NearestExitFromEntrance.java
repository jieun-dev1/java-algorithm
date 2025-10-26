package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class NearestExitFromEntrance {


    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance);
    }

    public int bfs(char[][] maze, int[] entrance) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int length = -1;
        //BFS 는 거리 순으로
        while (!queue.isEmpty()) {
            int size = queue.size();
            length += 1;

            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                if (location[0] == 0 || location[0] == maze.length - 1 || location[1] == 0 || location[1] == maze[0].length - 1) {
                    if (maze[location[0]][location[1]] == '.') {
                        //should not be the entrance
                        if (!(location[0] == entrance[0] && location[1] == entrance[1])) {
                            return length;
                        }
                    }
                }

                //exit
                for (int j = 0; j < dx.length; j++) {
                    int nx = location[0] + dx[j];
                    int ny = location[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length) {
                        continue;
                    }
                    if (maze[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        char[][] maze ={{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1, 2};
//        char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
//        int[] entrance = {1, 0};

        NearestExitFromEntrance nearestExitFromEntrance = new NearestExitFromEntrance();
        System.out.println(nearestExitFromEntrance.nearestExit(maze, entrance));
    }
}