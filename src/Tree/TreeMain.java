package Tree;

import java.util.List;

public class TreeMain {
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode x = new TreeNode(5);
        TreeNode y = new TreeNode(6);
        TreeNode p = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = x;
        b.right = y;
        y.right = p;
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
//        List pre = tree.preorderTraversalRecursion(a);
//        System.out.println(pre);
//        List in = tree.inorderTraversalRecursion(a);
//        System.out.println(in);
//        List post = tree.postorderTraversalRecursion(a);
//        System.out.println(post);
//        List pre1 = tree.preorderTraversalLoopStack(a);
//        System.out.println(pre1);
        List in1 = tree.inorderTraversalLoopStack(a);
        System.out.println(in1);
//        List post1 = tree.postorderTraversalLoopStack(a);
//        System.out.println(post1);
    }
}
