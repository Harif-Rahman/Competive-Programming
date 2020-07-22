package Tree;

import LinkedList.PalindromeLinkedList234;

public class LinkedListInBinaryTree1367 {
    /*
    Given a binary tree root and a linked list with head as the first node.

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.



Example 1:



Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.
Example 2:



Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(10);
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.left.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(1);

 /*       listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.left.right = new TreeNode(8);
        treeNode.right.left.right.right = new TreeNode(3);
        treeNode.right.left.right.left = new TreeNode(1);
        treeNode.right.left.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(2);
        treeNode.right.right.left = new TreeNode(1);*/

        LinkedListInBinaryTree1367 linkedListInBinaryTree1367 = new LinkedListInBinaryTree1367();
        linkedListInBinaryTree1367.isSubPath(listNode,treeNode);
    }
     boolean found = false;
     ListNode head= null;
    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        helper(root,head);
        return found;
    }
    private  void helper(TreeNode root,ListNode node){
        if(node == null){
            found = true;
            return;
        }
        if(root == null){
            return;
        }
        helper(root.left,root.val == node.val ? node.next : head.val == node.val ? node.next : node);
        helper(root.right,root.val == node.val ? node.next : head.val == node.val ? node.next : node);
    }
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
