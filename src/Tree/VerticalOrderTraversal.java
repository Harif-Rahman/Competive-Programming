package Tree;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode('z');
        tree.left = new TreeNode('b');
        tree.left.left = new TreeNode('b');
        tree.left.right = new TreeNode('d');
        tree.right = new TreeNode('d');
        tree.right.left = new TreeNode('a');
        tree.right.right = new TreeNode('c');
    }
    private static void verticalOrderTraversal(TreeNode node,int dist){
        if(node == null){
            return;
        }
        verticalOrderTraversal(node.left,dist-1);
        verticalOrderTraversal(node.right,dist+1);


    }
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }
    }
}
