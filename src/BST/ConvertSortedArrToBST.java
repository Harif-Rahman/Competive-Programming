package BST;

public class ConvertSortedArrToBST {
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        sortedArrayToBST(arr);

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        root =  bst(nums,0,nums.length-1);
        return root;
    }
    private static TreeNode bst(int[] nums, int low, int high){
        if(low <= high){
            int mid = low + (high-low)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = bst(nums,low,mid-1);
            root.right = bst(nums,mid+1,high);
            return root;
        }
        return null;

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
