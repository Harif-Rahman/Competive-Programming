package Tree;

import java.util.List;

public class LargestValueinEachTreeRow515 {
    /*
    515. Find Largest Value in Each Tree Row
Medium

628

52

Add to List

Share
You need to find the largest value in each row of a binary tree.

Example:
Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]
     */
    public static void main(String[] args) {

    }

    private void helper(TreeNode root,int height,List<Integer> ls){
        if(root == null)
            return;
        if(ls.size() == height){
            ls.add(root.val);
        }else{
            ls.add(height,Math.max(ls.get(height),root.val));
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
