package Tree;

public class SmalllestStringStartingFromRootToLeaf988 {
    private static String res = null;
    public static void main(String[] args) {
        TreeNode tree = new TreeNode('z');
        tree.left = new TreeNode('b');
        tree.left.left = new TreeNode('b');
        tree.left.right = new TreeNode('d');
        tree.right = new TreeNode('d');
        tree.right.left = new TreeNode('a');
        tree.right.right = new TreeNode('c');
        smallestFromLeaf(tree,"");
        System.out.println(new StringBuilder(res).reverse().toString());
    }
    public static String smallestFromLeaf(TreeNode root,String  str) {
        if(root == null)
            return null;
        str = root.val + str;
        if(root.left == null && root.right == null){
            // leaf
            if(res == null || res.compareTo(str) > 0){
                res = str;
            }
        }
        smallestFromLeaf(root.left,str);
        smallestFromLeaf(root.right,str);
        return res;
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
