package unionfind;

/**
 * Description: Regions Cut By Slashes
 * LC959 由斜杠划分区域  https://leetcode-cn.com/problems/regions-cut-by-slashes/
 * @author HarryUp
 * @date 2021/1/25
 */
public class RegionsCutBySlashes {

    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        UnionFind uf = new UnionFind(len * len * 4);
        for (int i = 0; i < len; i++) {
            char[] c = grid[i].toCharArray();
            for (int j = 0; j < len; j++) {
                int index = ((i * len) + j) * 4;
                // 通过斜杠单元内合并
                if (c[j] == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (c[j] == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index, index + 1);
                    uf.union(index, index + 2);
                    uf.union(index, index + 3);
                }
                // 单元格间合并
                // 上+左合并
                if (i - 1 >= 0) {
                    uf.union(index, ((i - 1) * len + j) * 4 + 2);
                }
                if (j - 1 >= 0) {
                    uf.union(index + 3, ((i * len) + j - 1) * 4 + 1);
                }
//                // 上+右合并
//                if (i - 1 >= 0) {
//                    uf.union(index, ((i - 1) * len + j) * 4 + 2);
//                }
//                if (j + 1 < len) {
//                    uf.union(index + 1, ((i * len) + j + 1) * 4 + 3);
//                }
//                // 下+左合并
//                if (i + 1  < len) {
//                    uf.union(index + 2, ((i + 1) * len + j) * 4);
//                }
//                if (j - 1 >= 0) {
//                    uf.union(index + 3, ((i * len) + j - 1) * 4 + 1);
//                }
//                // 下+右合并
//                if (i + 1  < len) {
//                    uf.union(index + 2, ((i + 1) * len + j) * 4);
//                }
//                if (j + 1 < len) {
//                    uf.union(index + 1, ((i * len) + j + 1) * 4 + 3);
//                }
            }
        }
        return uf.getCount();
    }

    private class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
//            count = n;
        }

        private int find (int x) {
            if (x == parent[x]) {
                ++count;
            }
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        private void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootX]++;
            }
            count--;
        }

        private int getCount() {
            return count;
        }
    }

    public int regionsBySlashes2(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        UnionFind2 unionFind = new UnionFind2(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                // 二维网格转换为一维表格
                int index = 4 * (i * N + j);
                char c = row[j];
                // 单元格内合并
                if (c == '/') {
                    // 合并 0、3，合并 1、2
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (c == '\\') {
                    // 合并 0、1，合并 2、3
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                // 单元格间合并
                // 向右合并：1（当前）、3（右一列）
                if (j + 1 < N) {
                    unionFind.union(index + 1, 4 * (i * N + j + 1) + 3);
                }
                // 向下合并：2（当前）、0（下一行）
                if (i + 1 < N) {
                    unionFind.union(index + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return unionFind.getCount();
    }

    private class UnionFind2 {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind2(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                count++;
            }
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count--;
        }
    }
}
