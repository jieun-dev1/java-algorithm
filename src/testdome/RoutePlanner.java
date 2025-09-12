package testdome;


public class RoutePlanner {


    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {


        boolean[][] visited = new boolean[mapMatrix.length][mapMatrix[0].length];
        if (!mapMatrix[fromRow][fromColumn]) {
             return false;
        }
        return dfs(mapMatrix, fromRow, fromColumn, visited, toRow, toColumn);
    }

    public static boolean dfs(boolean[][] mapMatrix, int row, int col, boolean[][] visited, int toRow, int toColumn) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        if (row < 0 || row > mapMatrix.length || col < 0 || col > mapMatrix[0].length) {
            return false;
        }
        //index out of bounds 에러 처리가 용이함.
        if (visited[row][col] || !mapMatrix[row][col]) {
            return false;
        }
        if (row == toRow && col == toColumn) {
            return true;
        }
        visited[row][col] = true;

        for (int i = 0; i < dx.length; i++) {
            for (int j = 0; j < dy.length; j++) {
                int nx = row + dx[i];
                int ny = col + dy[j];
                //should be wrapped with if
                 if (dfs(mapMatrix, nx, ny, visited, toRow, toColumn)) {
                     return true;
                 }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
