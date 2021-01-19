package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class checkCompletenessOfBT958 {
    /*
    Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.



Example 1:


Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:


Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode pop = queue.remove();
                if(pop == null){
                    flag = true;
                }else{
                    if(flag){
                        return false;
                    }
                    queue.add(pop.left);
                    queue.add(pop.right);
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
