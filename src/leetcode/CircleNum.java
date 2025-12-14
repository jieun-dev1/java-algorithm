package leetcode;

public class CircleNum {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        int count = 0;
        for (int i=0; i<isConnected.length;i++) {
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, i);
                count ++;   //when not connected to anyone, still counted
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, boolean[] isVisited, int from) {
        isVisited[from] = true;
        for (int i= 0; i<isConnected[from].length;i++) {
            if (isConnected[from][i] == 1 && isVisited[i] == false) {
                dfs(isConnected, isVisited, i);
            }
        }
    }
}
