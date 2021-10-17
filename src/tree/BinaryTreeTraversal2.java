package tree;

import java.util.*;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/13
 */
public class BinaryTreeTraversal2 {
    public List<Integer> preorder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs_preorder(root, res);
        return res;
    }

    private void dfs_preorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            dfs_preorder(root.left, list);
            dfs_preorder(root.right, list);
        }
    }

    public List<Integer> preorder2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            root = root.right;
        }
        return res;
    }

    public List<Integer> preorder3(TreeNode root) {
        TreeNode predecessor = null;
        LinkedList<Integer> res = new LinkedList<>();
        while (root != null) {
            predecessor = root.left;
            if (predecessor != null) {
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    res.add(root.val);
                    root = root.left;
                } else {
                    //是否修改原来的树结构
                    predecessor.right = null;

                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs_inorder(root, res);
        return res;
    }

    private void dfs_inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs_inorder(root.left, list);
            list.add(root.val);
            dfs_inorder(root.right, list);
        }
    }

    public List<Integer> inorder2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorder3(TreeNode root) {
        TreeNode predecessor = null;
        LinkedList<Integer> res = new LinkedList<>();
        while (root != null) {
            predecessor = root.left;
            if (predecessor != null) {
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    //是否修改原来的树结构
                    predecessor.right = null;

                    res.add(root.val);
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
