package unionfind;

import java.util.Arrays;

public class CheckCycle {
    public boolean checkCycle(int[][] edges, int node) {
        int[] rank = new int[node + 1];
        int[] parents = new int[node + 1];
        Arrays.fill(parents, -1); // 初始化所有节点的父节点都为-1
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (union(x, y, parents, rank)) return true;
        }
        return false;
    }

    private int find(int x, int[] parents) {
        // 查找节点最终指向的根节点， 简单的循环
        while (parents[x] != -1) {
            x = parents[x];
        }
        return x;
    }

    private boolean union(int x, int y, int[] parents, int[] rank) {
        // 合并集合
        // 通过找到各自的根节点，如果根节点一致，则属于同一个树，不能合并，否则可以合并
        // 通过比较根节点的高度，来防止树过度增长，即压缩路径
        int x_root = find(x, parents);
        int y_root = find(y, parents);
        if (x_root != y_root) {
            if (rank[x_root] > rank[y_root]) {
                parents[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parents[x_root] = y_root;
            } else if (rank[x_root] == rank[y_root]) {
                parents[x_root] = y_root;
                rank[y_root] += 1;
            }
        }
        return x_root == y_root;
    }
}
