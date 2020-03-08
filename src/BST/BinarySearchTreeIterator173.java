package BST;

import java.util.Stack;
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.



Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 */
public class BinarySearchTreeIterator173 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);
        tree.right.right = new TreeNode(20);
        tree.right.left = new TreeNode(9);
        BSTIterator bstIterator = new BSTIterator(tree);
        System.out.println(bstIterator.next());
    }

    /**
     * having a stack to maintain the smallest elements
     */
    static class BSTIterator {
        Stack<Integer> st = new Stack<>();

        public BSTIterator(TreeNode root) {
            fillStack(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return st.pop();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !st.isEmpty();
        }

        private void fillStack(TreeNode root) {
            if (root == null)
                return;
            fillStack(root.right);
            st.push(root.val);
            fillStack(root.left);
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
