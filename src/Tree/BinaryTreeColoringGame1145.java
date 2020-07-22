package Tree;

public class BinaryTreeColoringGame1145 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        btreeGameWinningMove(tree,7,3);
    }
    static int left, right, val;
    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        count(root);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private static int count(TreeNode node) {
        if (node == null) return 0;
        int l = count(node.left), r = count(node.right);
        if (node.val == val) {
            left = l;
            right = r;
        }
        return l + r + 1;
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
