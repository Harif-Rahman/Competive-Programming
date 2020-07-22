package BST;


public class SumRootToLeafNumbers1022 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(0);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(1);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(1);
        sumRootToLeaf(tree);


    }
    static int sum =0;
    public static int sumRootToLeaf(TreeNode root) {
        helper(root,0);
        return sum;
    }

    private static void helper(TreeNode root,int val){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            sum += (val << 1) + root.val;
        }
        helper(root.left,(val << 1) + root.val);
        helper(root.right,(val << 1) + root.val);
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
