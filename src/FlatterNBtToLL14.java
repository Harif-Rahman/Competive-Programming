public class FlatterNBtToLL14 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        flatten(tree);
    }
    public static void flatten(TreeNode root) {
        TreeNode cl = new TreeNode(root.val);
        preOrderFlattern(root,cl);
        root = cl;
        System.out.println(root);
    }

    private static TreeNode preOrderFlattern(TreeNode root,TreeNode cl){
        if(root == null || cl == null )
            return cl;
        cl.right = new TreeNode(root.val);
        cl = preOrderFlattern(root.left,cl.right);
        preOrderFlattern(root.right,cl);
        return cl;
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
