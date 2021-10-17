package tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    final String none = "null";
    private TreeNode[] tree;
    private TreeNode root;

    public TreeNode(int[] nums) {
        int n = nums.length;
        tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new TreeNode(nums[i]);
        }
        for (int i = 0; i < n / 2; i++) {
            if (2 * i + 1 < n) {
                tree[i].left = tree[2 * i + 1];
            }
            if (2 * i + 2 < n) {
                tree[i].right = tree[2 * i + 2];
            }
        }
        root = tree[0];
    }

    public TreeNode(String nums) {
        String[] arr = Arrays.stream(nums.split(",")).map(String::strip).toArray(String[]::new);
        int n = arr.length;
        tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (!none.equals(arr[i])) {
                tree[i] = new TreeNode(Integer.parseInt(arr[i]));
            }
        }
        for (int i = 0; i < n / 2; i++) {
            if (!none.equals(arr[i])) {
                if (2 * i + 1 < n && !none.equals(arr[2 * i + 1])) {
                    tree[i].left = tree[2 * i + 1];
                }
                if (2 * i + 2 < n && !none.equals(arr[2 * i + 2])) {
                    tree[i].right = tree[2 * i + 2];
                }
            }
        }
        root = tree[0];
    }

    public TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void bfs_traversal() {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            res.add(cur.val);
            if (cur.left != null) {
                queue.offerLast(cur.left);
            }
            if (cur.right != null) {
                queue.offerLast(cur.right);
            }
        }
        System.out.println(res);
    }

    public void dfs_traversal() {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            res.add(cur.val);
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
        System.out.println(res);
    }
}
