package Tree;

public class DeleteNodesWithGivenValue1325 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);
        helper(treeNode,2);
        System.out.println(treeNode);
    }
    private static void helper(TreeNode root,int target){
        if(root == null)
            return;
        helper(root.left,target);
        helper(root.right,target);
        if(root.left == null && root.right == null && root.val == target){
            root = null;
        }
    }

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
