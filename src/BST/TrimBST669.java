package BST;

public class TrimBST669 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(0);
        tree.right = new TreeNode(2);
        helper(tree,1,2);
    }
    private static TreeNode helper(TreeNode root,int L,int R){
        if(root == null){
            return null;
        }
        if(root.val < L){
            System.out.println("Entered");
            root = root.right;
            if(root != null){
                root.left = null;
            }
        }else{
            if(root.val > R){
                root = root.left;
                if(root != null){
                    root.right = null;
                }
            }
        }
        helper(root != null ? root.left : null,L,R);
        helper(root != null ? root.right: null,L,R);
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
