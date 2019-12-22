package LinkedList;

public class RemoveNthNodeFromEndofLL19 {
    /*
    Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
     */
    /*
    hA one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward, to maintain a gap of n between
    the two pointers and then move both at the same speed. Finally, when the fast pointer reaches the end,
    the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.

    WANNT TO DELETE 2ND last node
    eg :  1     2    3   4   5
          sp ---n--- fp
                sp      fp
                    sp      fp
                    reaches end stop
                    now set sp.next = sp.next.next;
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fp=dummy;
        ListNode sp = dummy;
        for(int i=0;i<n;i++){
            fp = fp.next;
        }
        while(fp.next != null){
            fp=fp.next;
            sp=sp.next;
        }
        sp.next = sp.next.next;
        return dummy.next;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
