package Tree;

public class UnivaluedTree965 {
    public static void main(String[] args) {

    }
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;
        return helper(root,root.val);
    }

    /**
     *
     * ACCEPTED
     * @param root
     * @param val
     * @return
     */
    private boolean helper(TreeNode root,int val){
        if(root == null)
            return true;
        return root.val == val && helper(root.left,val) && helper(root.right,val);
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
