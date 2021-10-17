package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/21
 */
public class BinaryTreeTraversal210421 {
    public List<Integer> preorderI(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder_dfs(root, res);
        return res;
    }

    private void preorder_dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder_dfs(root.left, res);
            preorder_dfs(root.right, res);
        }
    }

    public List<Integer> preorderII(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public List<Integer> preorderIII(TreeNode root) {
        List<Integer> res = new LinkedList<>();
//        while (root != null) {
//            TreeNode node = root.left;
//            if (node != null) {
//
//            }
//            while (root.)
//        }
        return res;
    }
}
