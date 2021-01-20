package unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
1202. 交换字符串中的元素
https://leetcode-cn.com/problems/smallest-string-with-swaps/
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        char[] charArray = s.toCharArray();
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>(s.length());
        for (int i = 0; i < charArray.length; i++) {
            int root = uf.find(i);
//            if (map.containsKey(root)) {
//                map.get(root).offer(charArray[i]);
//            } else {
//                PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                minHeap.offer(charArray[i]);
//                map.put(root, minHeap);
//            }
            map.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sb.append(map.get(uf.find(i)).poll());
        }
        return sb.toString();
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            if (connected(x, y)) return;
            parent[find(x)] = find(y);
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
