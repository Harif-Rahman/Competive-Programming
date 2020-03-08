package BST;

public class SumOfLeftLeavesBT {
    private static int sum=0;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        helper(tree);
        System.out.println(sum);
    }
    private static int helper(TreeNode root){
        if(root == null)
            return 0;
        int leftVal = helper(root.left);
        int rightVal = helper(root.right);
        if(root.left == null && root.right == null){
            sum+=leftVal;
        }
        return root.val;
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
