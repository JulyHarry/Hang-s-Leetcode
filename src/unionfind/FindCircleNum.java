package unionfind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode-cn.com/problems/number-of-provinces/
547. 省份数量
 */

public class FindCircleNum {
    public int findCircleNum (int[][] isConnected) {
        int[] parents = new int[isConnected.length];
        Arrays.fill(parents, -1);
        int[] rank = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parents, rank);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                cnt++;
            }
        }
        return cnt;
    }

    private int find(int x, int[] parents) {
        while (parents[x] != -1) {
            x = parents[x];
        }
        return x;
    }

    private void union(int x, int y, int[] parents, int[] rank) {
        int x_root = find(x, parents);
        int y_root = find(y, parents);
        if (x_root != y_root) {
            if (rank[x_root] > rank[y_root]) {
                parents[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parents[x_root] = y_root;
            } else if (rank[x_root] == rank[y_root]) {
                parents[x_root] = y_root;
                rank[y_root]++;
            }
        }
    }

    // BFS
    public int findCircleNumBFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                cnt++;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < isConnected.length; k++) {
                        if(!visited[k] && isConnected[j][k] == 1) {
                            queue.offer(k);
                        }
                    }
                }
            }
        }
        return cnt;
    }

    // DFS
    public int findCircleNumDFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int sum = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                sum++;
                findCircleNum_DFS(i, isConnected, visited);
            }
        }
        return sum;
    }

    private void findCircleNum_DFS(int i, int[][] isConnected, boolean[] visited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                findCircleNum_DFS(j, isConnected, visited);
            }
        }
    }
}
