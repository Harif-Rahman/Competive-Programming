package BST;

import java.util.ArrayList;
import java.util.List;

public class DeepestLeavesSum1302 {
    /*
    Given a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
            */

    public int deepestLeavesSum(TreeNode root) {
        List<Integer> res = helper(root,new ArrayList<Integer>(),0);
        return res.get(res.size()-1);
    }

    /**
     * having a list which stores the sum of the levels initally we are all storing the first values using preorder traversal and adding the
     * sum based on the current levels
     * @param root
     * @param ls
     * @param height
     * @return
     */

    private List<Integer> helper(TreeNode root,List<Integer> ls,int height){
        if(root == null){
            return ls;
        }
        if(height == ls.size()){
            ls.add(root.val);
        }else{
            ls.set(height,ls.get(height)+root.val);
        }
        helper(root.left,ls,height+1);
        helper(root.right,ls,height+1);
        return ls;
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
