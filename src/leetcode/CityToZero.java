package leetcode;

import java.util.*;

public class CityToZero {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1});
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0});
        }

        return dfs(0, -1, graph);
    }

    private int dfs(int node, int parent, Map<Integer, List<int[]>>graph) {
        int changes = 0;

        for (int[] next: graph.getOrDefault(node, Collections.emptyList())) {
            int neighbor = next[0];
            int cost = next[1];

            if (neighbor == parent) continue;

            changes += cost + dfs(neighbor, node, graph);
        }
        return changes;
    }

    public static void main(String[] args) {
        //n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]  - 3
        //n = 5, connections = [[1,0],[1,2],[3,2],[3,4]] - 2

        CityToZero city = new CityToZero();
        int n = 6;
        int[][] connections = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(city.minReorder(n, connections));
    }
}
