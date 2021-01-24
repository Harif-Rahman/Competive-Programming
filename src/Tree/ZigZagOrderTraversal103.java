package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagOrderTraversal103 {
    /**
     * TC : TOTAL NUMBER OF NODES
     * SC : TOTAL NUMBER OF NOES
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();

        oddStack.push(root);
        int level = 1;
        while(!oddStack.isEmpty() || !evenStack.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            if(level % 2 == 1){
                while(!oddStack.isEmpty()){
                    TreeNode pop = oddStack.pop();
                    ls.add(pop.val);
                    if(pop.left != null){
                        evenStack.add(pop.left);
                    }
                    if(pop.right != null){
                        evenStack.add(pop.right);
                    }
                }
            }else{
                while(!evenStack.isEmpty()){
                    TreeNode pop = evenStack.pop();
                    ls.add(pop.val);
                    if(pop.right != null){
                        oddStack.add(pop.right);
                    }
                    if(pop.left != null){
                        oddStack.add(pop.left);
                    }
                }
            }
            res.add(ls);
            level++;
        }
        return res;
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
