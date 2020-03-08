package Tree;

public class BinaryTreeTilt563 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        System.out.println(findTilt(tree));
    }
    static int lsum=0;
    static int rsum=0;
    public static int findTilt(TreeNode root) {
        helper(root,root);
        return Math.abs(lsum-rsum);
    }
    private static void helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return;
        if(root1 == null){
            rsum+=root2.val;
            return;
        }
        if(root2 == null){
            lsum+=root1.val;
            return;
        }
        helper(root1.left,root2.right);
        helper(root1.right,root2.left);
        lsum+=root1.val;
        rsum+=root2.val;
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
