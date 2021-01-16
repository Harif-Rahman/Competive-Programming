package BST;

import java.util.Stack;

public class ConvertBSTtoGreaterTree538 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);
        tree.right.right = new TreeNode(20);
        tree.right.left = new TreeNode(9);
        bstToGst(tree);
    }
    // here using the stack
    public static TreeNode bstToGstIterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }

    /**
     * without using instance variable
     * @param root
     * @return
     */
    public static TreeNode bstToGst(TreeNode root) {
        TreeNode sumNode = new TreeNode(0);
        convertToGSt(root,sumNode);
        return root;
    }
    private static void convertToGSt(TreeNode root,TreeNode sumNode){
        if(root == null){
            return;
        }
        convertToGSt(root.right,sumNode);
        sumNode.val +=  root.val;
        root.val = sumNode.val;
        convertToGSt(root.left,sumNode);
    }
    // wrong one
    public static TreeNode bstToGstWithInteger(TreeNode root) {
        Integer sum = 0; // dont user integer on recursion its values will not be changed instead use the above one
        convertToGStWitInteger(root,sum);
        return root;
    }
    private static void convertToGStWitInteger(TreeNode root,Integer sum){
        if(root == null){
            return;
        }
        convertToGStWitInteger(root.right,sum);
        sum += root.val;
        root.val = sum;
        convertToGStWitInteger(root.left,sum);
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
