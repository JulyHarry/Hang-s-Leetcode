package unionfind;

import java.util.HashMap;
import java.util.List;

/**
 * @author HarryUp
 * 399. 除法求值
 * https://leetcode-cn.com/problems/evaluate-division/
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();
        UnionFind uf = new UnionFind(2 * len);
        HashMap<String, Integer> map = new HashMap<>(2 * len);
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
            if (!map.containsKey(y)) {
                map.put(y, id++);
            }
            uf.union(map.get(x), map.get(y), values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!map.containsKey(x) || !map.containsKey(y)) {
                result[i] = -1.0;
            } else {
                result[i] = uf.connected(map.get(x), map.get(y));
            }
        }
        return result;
    }

    private class UnionFind {
        int[] parent;
        double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                // parent[x] 是 x 的父节点
                int origin = parent[x];
                parent[x] = find(parent[x]);
                // weight[x] 仍然是 x 本身的权值， 他的更新 需要乘以父节点的权值 即 weight[parent[x]]
                // 但是这个 parent[x] 中的 x 需要使用 origin 传递 即 parent[origin]
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public double connected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                return -1.0;
            } else {
                return weight[x] / weight[y];
            }
        }
    }
}
