package unionfind;

import java.util.Arrays;

public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        FindUnion fu = new FindUnion(26);
        for (String equation : equations) {
            int x = equation.charAt(0) - 'a';
            int y = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                fu.union(x, y);
            }
        }
        for (String equation : equations) {
            int x = equation.charAt(0) - 'a';
            int y = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!' && fu.isConnected(x, y)) {
                return false;
            }
        }
        return true;
    }

    private class FindUnion{
        private int[] parent;

        public FindUnion(int n) {
            this.parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        private void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public boolean equationsPossible2(String[] equations) {
        int[] parent = new int[26];
        Arrays.fill(parent, -1);
        int[] rank = new int[26];
        Arrays.sort(equations, (o1, o2) -> o2.charAt(1) - o1.charAt(1));
        for (String equation : equations) {
            int x = equation.charAt(0) - 'a';
            int y = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                union(x, y, parent, rank, true);
            }
            if (equation.charAt(1) == '!' && union(x, y, parent, rank, false)) {
                return false;
            }
        }
        return true;
    }

    private int find(int x, int[] parent) {
        while (parent[x] != -1) {
            x = parent[x];
        }
        return x;
    }

    private boolean union(int x, int y, int[] parent, int[] rank, boolean merge) {
        int x_root = find(x, parent);
        int y_root = find(y, parent);
        if (merge && x_root != y_root) {
            if (rank[x_root] > rank[y_root]) {
                parent[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parent[x_root] = y_root;
            } else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
        }
        return x_root == y_root;
    }
}
