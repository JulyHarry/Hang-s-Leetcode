package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    private List<Integer> prelist = new ArrayList<>();
    private List<Integer> inlist = new ArrayList<>();
    private List<Integer> postlist = new ArrayList<>();

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return this.prelist;
        }
        preorderTraversalRecursionSupport(root);
        return this.prelist;
    }

    private void preorderTraversalRecursionSupport(TreeNode root) {
        if (root == null) {
            return;
        }
        this.prelist.add(root.val);
        preorderTraversalRecursionSupport(root.left);
        preorderTraversalRecursionSupport(root.right);
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return this.inlist;
        }
        inorderTraversalRecursionSupport(root);
        return this.inlist;
    }

    private void inorderTraversalRecursionSupport(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursionSupport(root.left);
        this.inlist.add(root.val);
        inorderTraversalRecursionSupport(root.right);
    }

    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return this.postlist;
        }
        postorderTraversalRecursionSupport(root);
        return this.postlist;
    }

    private void postorderTraversalRecursionSupport(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursionSupport(root.left);
        postorderTraversalRecursionSupport(root.right);
        this.postlist.add(root.val);
    }

    public List<Integer> preorderTraversalLoop(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null) {
                TreeNode p = stack.pop();
                list.add(p.val);
                if (p.right != null) {
                    stack.push(temp.right);
                }
            } else {
                stack.push(temp.left);
                temp.left = null;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversalLoop(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return list;
    }

    public List<Integer> preorderTraversalLoopStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            if (n != null) {
                list.add(n.val);
                stack.push(n.right);
                stack.push(n.left);
            }
        }
        return list;
    }

    public List<Integer> inorderTraversalLoopStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public List<Integer> postorderTraversalLoopStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            if (n != null) {
                list.add(0, n.val);
                stack.push(n.left);
                stack.push(n.right);
            }
        }
        return list;
    }
}
