package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceBST1382 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        balanceBST(root);
        System.out.println(root);
    }
    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        // get inorder list
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ls.add(curr.val);
            curr = curr.right;
        }
        return getBalancedBST(ls,0,ls.size()-1);
    }
    private static TreeNode getBalancedBST(List<Integer> ls,int start,int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(ls.get(mid));
        root.left = getBalancedBST(ls,start,mid-1);
        root.right = getBalancedBST(ls,mid+1,end);
        return root;
    }
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val ;
        TreeNode(int val){
            this.val = val;
        }
    }
}
