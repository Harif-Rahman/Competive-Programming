package LinkedList;

public class KthNodeFromLast {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        int index = 3;
        getNthFromLast(listNode,new ListNode(1),3);
    }
    private static ListNode getNthFromLast(ListNode head,ListNode dummy,int k){

        if(head == null){
            return null;
        }

        dummy.val++;
        ListNode res = getNthFromLast(head.next,dummy,k);
        dummy.val--;
        if(dummy.val == k){
            return head;
        }
        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
