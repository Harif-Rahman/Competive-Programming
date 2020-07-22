package Tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    /*
    Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
     */
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(6);
    }


    /**
     * TC : O(N) TOTAL NODES IN TREE
     * @param root
     */
    private void helper(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
            if(!stack.isEmpty()){
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }


    /**
     * RECURSIVE
     * @param root
     */
    private void helper1(TreeNode root){
        if(root == null)
            return;
        helper1(root.left);
        helper1(root.right);
        if(root.left != null){
            TreeNode temp = root.left;
            while(temp.right != null){
                temp = temp.right;
            }
            TreeNode dRight = root.right;
            root.right = root.left;
            root.left = null;
            temp.right = dRight;
        }
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
