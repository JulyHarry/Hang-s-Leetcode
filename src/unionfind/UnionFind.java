package unionfind;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        // 隔代压缩
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;

//        // 完全压缩
//        if (x != parent[x]) {
//            parent[x] = find(x);
//        }
//        return x;
    }

    private void union(int x, int y) {
        // 按秩合并
        if (isConnected(x, y)) return;
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] == rank[rootY]) {
            parent[rootX] = rootY;
            rank[rootY]++;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = parent[rootX];
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        }
//        // 没有按秩合并
//        if (!isConnected(x, y)) parent[find(y)] = find(x);
    }

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
