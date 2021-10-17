import tree.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree {
    public static int generateAmount(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i<= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n==0) {
            return new ArrayList<TreeNode>();
        }
        return generateList(1, n);
    }

    private static ArrayList<TreeNode> generateList(int start, int end) {
        ArrayList<TreeNode> rootTree = new ArrayList<>();
        if (start > end ) {
            rootTree.add(null);
            return rootTree;
        }
        for (int i= start; i<=end; i++) {
            ArrayList<TreeNode> leftTree = generateList(start, i-1);
            ArrayList<TreeNode> rightTree = generateList(i+1, end);
            for (TreeNode l : leftTree) {
                for (TreeNode r:rightTree) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = l;
                    curTree.right = r;
                    rootTree.add(curTree);
                }
            }
        }
        return rootTree;
    }

    public static void main(String[] args) {
        System.out.println(generateAmount(4));
        System.out.println(generateTrees(4));
    }
}
