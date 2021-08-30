/*
 * @Desc:  LC00673 - 最长递增子序列的个数
 * @Url:   https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * @Date:  2021-08-28 15:13:51
 * @Content:
 //给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 👍 358 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.Arrays;

class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
//        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
//        int[] nums = {1, 3, 5, 4, 7, 3, 2, 34, 235, 32, 43, 2, 5, 6, 324, 23, 224, 362, 4};
////        [1,3,5,4,7,3,2,34,235,32,43,2,5,6,324,23,224,362,4]
//        int numberOfLIS = solution.findNumberOfLIS(nums);
//        System.out.println("numberOfLIS = " + numberOfLIS);
        Solution2 solution = new NumberOfLongestIncreasingSubsequence().new Solution2();
        int[] nums = {1, 3, 5, 4, 7};
//        [1,3,5,4,7,3,2,34,235,32,43,2,5,6,324,23,224,362,4]
        int numberOfLIS = solution.findNumberOfLIS(nums);
        System.out.println("numberOfLIS = " + numberOfLIS);
    }

    /*
     * Solution is here.
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] lens = new int[nums.length];
            int[] counts = new int[nums.length];
            Arrays.fill(lens, 1);
            Arrays.fill(counts, 1);
            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (lens[j] >= lens[i]) {
                            lens[i] = lens[j] + 1;
                            counts[i] = counts[j];
                        } else if (lens[i] == lens[j] + 1) {
                            counts[i] += counts[j];
                        }
                    }
                }
                maxLen = Math.max(maxLen, lens[i]);
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (lens[i] == maxLen) {
                    res += counts[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public Value merge(Value v1, Value v2) {
            if (v1.length == v2.length) {
                if (v1.length == 0) {
                    return new Value(0, 1);
                }
                return new Value(v1.length, v1.count + v2.count);
            }
            return v1.length > v2.length ? v1 : v2;
        }

        public void insert(Node node, int key, Value val) {
            if (node.range_left == node.range_right) {
                node.val = merge(val, node.val);
                return;
            } else if (key <= node.getRangeMid()) {
                insert(node.getLeft(), key, val);
            } else {
                insert(node.getRight(), key, val);
            }
            node.val = merge(node.getLeft().val, node.getRight().val);
        }

        public Value query(Node node, int key) {
            if (node.range_right <= key) {
                return node.val;
            } else if (node.range_left > key) {
                return new Value(0, 1);
            } else {
                return merge(query(node.getLeft(), key), query(node.getRight(), key));
            }
        }

        public int findNumberOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int min = nums[0], max = nums[0];
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            Node root = new Node(min, max);
            for (int num : nums) {
                Value v = query(root, num - 1);
                insert(root, num, new Value(v.length + 1, v.count));
            }
            return root.val.count;
        }
    }

    class Node {
        int range_left, range_right;
        Node left, right;
        Value val;

        public Node(int start, int end) {
            range_left = start;
            range_right = end;
            left = null;
            right = null;
            val = new Value(0, 1);
        }

        public int getRangeMid() {
            return range_left + (range_right - range_left) / 2;
        }

        public Node getLeft() {
            if (left == null) {
                left = new Node(range_left, getRangeMid());
            }
            return left;
        }

        public Node getRight() {
            if (right == null) {
                right = new Node(getRangeMid() + 1, range_right);
            }
            return right;
        }
    }

    class Value {
        int length;
        int count;

        public Value(int len, int ct) {
            length = len;
            count = ct;
        }
    }

}