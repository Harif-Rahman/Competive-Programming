package Tree;

import java.util.Arrays;

public class PseudoPalidromicPath1457 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(8);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(7);
        treeNode.left.right.left = new TreeNode(2);
        treeNode.left.right.left.right = new TreeNode(8);
        treeNode.left.right.left.right.right = new TreeNode(1);
        treeNode.left.right.right = new TreeNode(4);
        treeNode.left.right.right.right = new TreeNode(7);
        treeNode.left.right = new TreeNode(7);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(7);
        pseudoPalindromicPaths(treeNode);
    }
    static int count = 0;
    public static int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        dfs(root,arr,1);
        return count;
    }

    /**
     * TC : O(N-NO OF NODES)
     * sc O(10 + NO OF Nodes) -> O(N)
     * @param root
     * @param arr
     * @param height
     */
    private static void dfs(TreeNode root,int[] arr,int height){
        if(root == null){
            return;
        }
        arr[root.val]++;
        if(root.left == null && root.right == null){
            // leaf node
            System.out.println("leaf --->"+root.val);
            System.out.println(Arrays.toString(arr));
            if(canMakePalindrome(arr,height)){
                count++;
            }
        }
        dfs(root.left,arr,height+1);
        dfs(root.right,arr,height+1);
        arr[root.val]--; //decrease
    }

    private static boolean canMakePalindrome(int[] arr,int len){
        boolean excemption = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2 != 0){
                if(len % 2 == 0 ){
                    return false;
                }else{
                    if(excemption){
                        return false;
                    }else{
                        excemption = true;
                    }
                }
            }
        }
        return true;
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
