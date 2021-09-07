/*
 * @Desc:  LC01584 - 连接所有点的最小费用
 * @Url:   https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 * @Date:  2021-09-07 09:53:31
 * @Content:
 //给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。 
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 
//val 的绝对值。 
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
// 
//
// 示例 3： 
//
// 
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
// 
//
// 示例 5： 
//
// 
//输入：points = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 1000 
// -10⁶ <= xi, yi <= 10⁶ 
// 所有点 (xi, yi) 两两不同。 
// 
// Related Topics 并查集 数组 最小生成树 👍 159 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.PriorityQueue;

class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int i = solution.minCostConnectPoints(points);
        System.out.println(i);
    }

    /*
     * Solution is here.
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            UnionFind uf = new UnionFind(points.length);
            PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> (a.distance - b.distance));
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    pq.add(new Edge(i, j, distance));
                }
            }
            for (int i = 0; i < points.length - 1; ) {
                Edge node = pq.poll();
                int begin = node.begin;
                int end = node.end;
                if (uf.union(begin, end)) {
                    res += node.distance;
                    i++;
                }
            }
            return res;
        }

        class Edge {
            int begin;
            int end;
            int distance;

            public Edge(int begin, int end, int distance) {
                this.begin = begin;
                this.end = end;
                this.distance = distance;
            }
        }

        class UnionFind {
            int[] parents;
            int[] rank;
            int size;

            public UnionFind(int n) {
                parents = new int[n];
                rank = new int[n];
                for (int i = 0; i < parents.length; i++) {
                    parents[i] = i;
                }
            }

            public int find(int x) {
                if (x != parents[x]) {
                    return find(parents[x]);
                }
                return x;
            }

            public boolean union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return false;
                }
                if (rank[rootX] < rank[rootY]) {
                    parents[rootX] = rootY;
                } else if (rank[rootY] < rank[rootX]) {
                    parents[rootY] = rootX;
                } else {
                    parents[rootY] = rootX;
                    rank[rootX]++;
                }
                size--;
                return true;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}