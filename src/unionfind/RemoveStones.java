package unionfind;

import java.util.HashMap;

/**
 * @author HarryUp
 * 947. 移除最多的同行或同列石头
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * 合并的意义！！！
 */
public class RemoveStones {
//    public int removeStones(int[][] stones) {
//        UnionFind uf = new UnionFind();
//        for (int[] stone : stones) {
//            uf.union(~stone[0], stone[1]);
//        }
//        return stones.length - uf.getCount();
//    }
//
//    private class UnionFind {
//        // 使用 hashmap 不使用数组的原因， 该题不知道初始化的大小
//        HashMap<Integer, Integer> map;
//        HashMap<Integer, Integer> rank;
//        int count = 0;
//
//        public UnionFind() {
//            this.map = new HashMap<>();
//            this.rank = new HashMap<>();
//        }
//
//        public int getCount() {
//            return this.count;
//        }
//
//        public int find(int x) {
//            if (!map.containsKey(x)) {
//                count++;
//                map.put(x, x);
//                rank.put(x, 0);
//            }
//            while (x != map.get(x)) {
//                map.put(map.get(x), map.get(map.get(x)));
//                x = map.get(x);
//            }
//            return x;
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) return;
//            if (rank.get(rootY) < rank.get(rootX)) {
//                map.put(rootY, rootX);
//            } else if (rank.get(rootX) < rank.get(rootY)) {
//                map.put(rootX, rootY);
//            } else {
//                map.put(rootX, rootY);
//                rank.put(rootX, rank.get(rootX) + 1);
//            }
//            count--;
//        }
//    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            uf.union(x, ~y);
        }
        return stones.length - uf.getCount();
    }

    private class UnionFind{
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> rank;
        private int count = 0;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        private int find (int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 1);
                ++count;
            }
            while (x != parent.get(x)) {
                parent.put(parent.get(x), parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        private void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else {
                parent.put(rootX, rootY);
                rank.put(rootX, rank.get(rootX) + 1);
            }
            --count;
        }

        private int getCount() {
            return count;
        }
    }
}
