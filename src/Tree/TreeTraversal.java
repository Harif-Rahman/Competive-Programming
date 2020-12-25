package Tree;

import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        /*
            1
          2   3
         4 5 6 7
         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.left.right = new TreeNode(5);
        tree.left.left = new TreeNode(4);
        inOrderTraversal(tree);
    }
    public static void inOrderTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = node;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                // it will push head and right
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode popped = stack.pop();
            System.out.println(popped.val);
            curr = popped.right;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
