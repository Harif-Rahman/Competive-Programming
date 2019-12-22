package BST;

public class KthSmallestElementBST {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.left.right = new TreeNode(2);
        tree.right = new TreeNode(4);
        int[] arr = new int[2];
        findKthSmallestElementRecursion(tree,4,arr);
        System.out.println(arr[1]);

    }
    // using inorder traversal recusrsively
    private static void findKthSmallestElementRecursion(TreeNode root, int k, int[] arr){
        if(root == null || arr[1] != 0)
            return;
        findKthSmallestElementRecursion(root.left, k,arr);
        arr[0]++;
        if(arr[0] == k){
            arr[1] = root.val;
            return ;
        }
        findKthSmallestElementRecursion(root.right, k,arr);
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
