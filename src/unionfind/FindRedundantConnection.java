package unionfind;

import java.util.Arrays;

public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        int[] result = new int[2];
        Arrays.fill(parents, -1);
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parents, rank)) {
                result[0] = edge[0];
                result[1] = edge[1];
            }
        }
        return result;
    }

    private int find(int x, int[] parents) {
        while (parents[x] != -1) {
            x = parents[x];
        }
        return x;
    }

    private boolean union(int x, int y, int[] parents, int[] rank) {
        int x_root = find(x, parents);
        int y_root = find(y, parents);
        if (x_root != y_root) {
            if (rank[x_root] > rank[y_root]) {
                parents[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parents[x_root] = y_root;
            } else {
                parents[y_root] = x_root;
                rank[x_root]++;
            }
        }
        return x_root == y_root;
    }
}