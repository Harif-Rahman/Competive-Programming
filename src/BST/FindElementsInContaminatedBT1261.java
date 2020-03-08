package BST;

import java.util.HashSet;
import java.util.Set;

/*
Given a binary tree with the following rules:

root.val == 0
If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

You need to first recover the binary tree and then implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
bool find(int target) Return if the target value exists in the recovered binary tre

Example 1:



Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]);
findElements.find(1); // return False
findElements.find(2); // return True
 */
public class FindElementsInContaminatedBT1261 {
    TreeNode root;
    Set<Integer> hs = new HashSet<>();
    public FindElementsInContaminatedBT1261(TreeNode root) {
        this.root = root;
        recoverBT(root,0);
    }
    private void recoverBT(TreeNode root,int val){
        if(root == null)
            return;
        hs.add(val);
        root.val = val;
        recoverBT(root.left,2*root.val + 1);
        recoverBT(root.right,2*root.val + 2);
    }
    public boolean find(int target) {
        return hs.contains(target);
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
