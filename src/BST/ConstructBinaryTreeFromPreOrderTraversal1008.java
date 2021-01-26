package BST;

public class ConstructBinaryTreeFromPreOrderTraversal1008 {
    public static void main(String[] args) {
        int[] arr = {8,5,1,7,10,12};
        bstFromPreorder(arr);
    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        return buildTreeWithPreOrder(preorder,0,preorder.length-1);
    }

    /**
     * n - arr length
     * tc : n * log n
     * sc : o(n)
     *
     *   [8,   5,1,7,10,12]
     *    r
     *    whichever the node which is less than 8 should come to left of 8 as per bst rules
     *
     * @param preOrder
     * @param left
     * @param right
     * @return
     */
    private static TreeNode buildTreeWithPreOrder(int[] preOrder,int left,int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[left]);
        int i;
        for(i = left+1;i<preOrder.length;i++){
            if(preOrder[i] > root.val){
                break;
            }
        }
        root.left = buildTreeWithPreOrder(preOrder,left+1,i-1);
        root.right = buildTreeWithPreOrder(preOrder,i,right);
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
