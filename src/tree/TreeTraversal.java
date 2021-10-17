package tree;

import Support.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    // 递归法
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<Integer>();
        preorderRecursive(root, res);
        return res;
    }

    private static void preorderRecursive(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderRecursive(root.left, list);
            preorderRecursive(root.right, list);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<Integer>();
        inorderRecursive(root, res);
        return res;
    }

    private static void inorderRecursive(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderRecursive(root.left, list);
            list.add(root.val);
            inorderRecursive(root.right, list);
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<Integer>();
        postorderRecursive(root, res);
        return res;
    }

    private static void postorderRecursive(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderRecursive(root.left, list);
            postorderRecursive(root.right, list);
            list.add(root.val);
        }
    }

    //非递归
    public static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node!=null) {
                list.add(node.val);
                stack.push(node.right);
                node = node.left;
            }
            else {
                node = stack.pop();
            }
        }
        return list;
    }

    public static List<Integer> preorderTraversal3(TreeNode root){
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            while(node != null){
                list.add(node.val);
                stack.push(node.right);
                node = node.left;
            }
        }
        return list;
    }

    public static List<Integer> inorderTraversal2(TreeNode root){
        List <Integer> list = new LinkedList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    public static List<Integer> inorderTraversal3(TreeNode root){
        List <Integer> list = new LinkedList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
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

    public static List<Integer> postorderTraversal2(TreeNode root){
        LinkedList <Integer> list = new LinkedList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node.left);
                list.addFirst(node.val);
                node = node.right;
            } else {
                node = stack.pop();
            }
        }
        return list;
    }

    public static List<Integer> postorderTraversal3(TreeNode root){
        LinkedList <Integer> list = new LinkedList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.addFirst(node.val);
                stack.push(node.left);
                node = node.right;
            }
            node = stack.pop();
        }
        return list;
    }

    public static List<Integer> postorderTraversal4(TreeNode root){
        LinkedList <Integer> list = new LinkedList<Integer>();
        Stack <TreeNode> stack1 = new Stack<TreeNode>();
        Stack <TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = root;
        stack1.push(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root4;
        root4.left = root5;
        root4.right = root3;
        System.out.println(preorderTraversal(root1));
        System.out.println(preorderTraversal2(root1));
        System.out.println(preorderTraversal3(root1));
        System.out.println(inorderTraversal(root1));
        System.out.println(inorderTraversal2(root1));
        System.out.println(inorderTraversal3(root1));
        System.out.println(postorderTraversal(root1));
        System.out.println(postorderTraversal2(root1));
        System.out.println(postorderTraversal3(root1));
        System.out.println(postorderTraversal4(root1));
    }
}
