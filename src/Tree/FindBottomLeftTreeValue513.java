package Tree;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftTreeValue513 {
    /*
    Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
     */
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.left = new TreeNode(5);
        tree.right.left.left = new TreeNode(7);
        tree.right.right = new TreeNode(6);
        System.out.println(findBottomLeftValue(tree));
    }

    /**
     * having a list which maintains the first value of every leve and return the last vaue in the list
     * @param root
     * @return
     */
    public static int findBottomLeftValue(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(root,0,ls);
        return ls.get(ls.size()-1);
    }
    private static void helper(TreeNode root,int height,List<Integer> ls){
        if(root == null)
            return;
        if(ls.size() == height){
            ls.add(root.val);
        }
        helper(root.left,height+1,ls);
        helper(root.right,height+1,ls);
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
