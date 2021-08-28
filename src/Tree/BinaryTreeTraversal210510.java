package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/10
 */
public class BinaryTreeTraversal210510 {
    public List<Integer> preorderMorris(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        while (root != null) {
            TreeNode node = root.left;
            if (node != null) {
                while (node.right != null && node.right != root) {
                    node = node.right;
                }
                if (node.right != root) {
                    node.right = root;
                    res.add(root.val);
                    root = root.left;
                } else {
                    root = root.right;
                    node.right = null;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderMorris(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        while (root != null) {
            TreeNode node = root.left;
            if (node != null) {
                while (node.right != null && node.right != root) {
                    node = node.right;
                }
                if (node.right != root) {
                    node.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    root = root.right;
                    node.right = null;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
