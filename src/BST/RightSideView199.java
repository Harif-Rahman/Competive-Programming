package BST;

import java.util.ArrayList;
import java.util.List;

public class RightSideView199 {
    /*
    Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
     */

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.left.right.left = new TreeNode(7);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(4);
        rightSideView(tree);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(root,ls,0);
        return ls;
    }

    /**
     * solved
     * @param node
     * @param ls
     * @param height
     */
    public static void helper(TreeNode node,List<Integer> ls,int height){
        if(node == null)
            return;
        if(height >= ls.size()){
            ls.add(node.val);
        }
        helper(node.right,ls,height+1);
        helper(node.left,ls,height+1);
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
