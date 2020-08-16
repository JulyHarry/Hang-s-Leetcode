package contest;

public class c05 {
    public int countPairs(TreeNode root, int distance) {
        char[] res = new char[11];
        TreeNode node = root;
        int height = -1;
        while (node != null){
            if (node.left != null || node.right != null) height++;
            else res[height]++;
        }
        return 0;
    }

    public static void main(String[] args) {
//        c05 c = new c05();
//        int i = c.countPairs(5,5);
//        System.out.println(i);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
