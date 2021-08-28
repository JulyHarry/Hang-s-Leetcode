package Iterator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Description:
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @author HarryUp
 * @date 2021/3/28
 */
public class BSTIterator {
    PriorityQueue<Integer> pq;

    public BSTIterator(TreeNode root) {
        pq = new PriorityQueue<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node == null) {
                continue;
            }
            pq.add(node.val);
            queue.offerLast(node.left);
            queue.offerLast(node.right);
        }
    }

    public int next() {
        return pq.poll();
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
