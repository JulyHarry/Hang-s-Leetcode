package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/10
 */
public class BinaryTreeDfs {
    /**
     * 872. 叶子相似的树
     * https://leetcode-cn.com/problems/leaf-similar-trees/
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = dfs(root1);
        List<Integer> res2 = dfs(root2);
        if (res1.size() != res2.size()) {
            return false;
        }
        for (int i = 0; i < res1.size(); i++) {
            if (res1.get(i) != res2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> dfs(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.left == null && root.right == null) {
                res.add(root.val);
            }
            root = root.right;
        }
        return res;
    }
}
