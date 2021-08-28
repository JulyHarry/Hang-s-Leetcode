package Iterator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @author HarryUp
 * @date 2021/3/28
 */
public class BSTIterator2 {
    Deque<Integer> queue;

    public BSTIterator2(TreeNode root) {
        queue = new LinkedList<>();
        inorder(queue, root);
    }

    private void inorder(Deque<Integer> queue, TreeNode root) {
        if (root != null) {
            inorder(queue, root.left);
            queue.offerLast(root.val);
            inorder(queue, root.right);
        }
    }

    public int next() {
        return queue.pollFirst();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
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
