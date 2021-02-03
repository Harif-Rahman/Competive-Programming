package Tree;

public class TrimBST {

    /**
     * tc : o(n)
     * sc :(o(n) it can be skewed
     *
     * intuition
     * if the root val is less than low then go to right
     * if the root is greater than right then go to left
     *
     *
     * @param root
     * @param low
     * @param right
     * @return
     */
    private TreeNode trim(TreeNode root,int low,int right){
        if(root == null){
            return null;
        }
        if(root.val < low){ // root which falls to left go to right
            return trim(root.right,low,right);
        }
        if(root.val > right){ // root which falls to right go to left
            return trim(root.left,low,right);
        }
        root.left = trim(root.left,low,right);
        root.right = trim(root.right,low,right);
        return root;
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
