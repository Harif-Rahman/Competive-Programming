package Tree;

import java.util.LinkedList;
import java.util.Queue;
/*
A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 */
public class EvenOddTree {
    /**
     * WORKING
     * TC : O(N- TOTAL NUMBER OF NODES)
     * SC :  O(N- TOTAL NUMBER OF NODES)
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int evenPrev = Integer.MIN_VALUE;
            int oddPrev = Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode pop = queue.remove();
                if(level % 2 == 0){
                    // strictly increasing
                    if(evenPrev >= pop.val || pop.val % 2 == 0){
                        return false;
                    }else{
                        evenPrev = pop.val;
                    }
                }else{
                    // strictly decreasing
                    if(oddPrev <= pop.val || pop.val % 2 == 1){
                        return false;
                    }else{
                        oddPrev = pop.val;
                    }
                }

                if(pop.left != null){
                    queue.add(pop.left);
                }
                if(pop.right != null){
                    queue.add(pop.right);
                }

            }
            level++;
        }
        return true;

    }
}
