package Tree;

import LinkedList.NumberOfRecentCalls933;

public class ConvertSortedListToBST {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        toBst(listNode);
    }
    private static TreeNode toBst(ListNode head){
        if(head == null )
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(temp != null){
            temp.next = null;
        }else {
            head = null;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBst(head);
        root.right = toBst(slow.next);
        return root;
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
