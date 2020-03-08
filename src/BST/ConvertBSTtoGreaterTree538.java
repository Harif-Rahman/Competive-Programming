package BST;

import java.util.Stack;

public class ConvertBSTtoGreaterTree538 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);
        tree.right.right = new TreeNode(20);
        tree.right.left = new TreeNode(9);
        convertBST1(tree);
    }
    private static int sum = 0;
    private static int currSum = 0;
    public static TreeNode convertBST(TreeNode root) {
        currSum = totSum(root);
        helper(root);
        return root;
    }
    private static void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        root.val = currSum;
        currSum -=root.val;
        helper(root.right);
    }

    private static int totSum(TreeNode root){
        if(root == null)
            return 0;
        totSum(root.left);
        sum+=root.val;
        totSum(root.right);
        return sum;
    }
    // --------------------------- above is my solution

    // here recursive one
    private static int sum1 = 0;

    public static TreeNode convertBST1(TreeNode root) {
        if (root != null) {
            convertBST1(root.right);
            sum1 += root.val;
            root.val = sum1;
            convertBST1(root.left);
        }
        return root;
    }
    // here using the stack
    public TreeNode ConvertBST(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        int sum = 0;
        while (node != null || !stack.isEmpty())
        {
            if (node != null)
            {
                stack.push(node);
                node = node.right;
            }
            else
            {
                node = stack.pop();
                sum += node.val;
                node.val = sum;

                node = node.left;
            }
        }

        return root;
    }





    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}
