package LinkedList;

public class RotateLL61 {
    /**
     * n= size of ll
     * TC : o(n + n) first n for getting the size of linked list and second for sp and fp concept
     * SC : O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int size = getSizeLL(dummy);

        k = k % size;
        if(k == 0){ // if size is divisible by k then its already in order
            return head;
        }
        ListNode fp = dummy;
        ListNode sp = dummy;


        for(int i=0;i<k;i++){
            fp = fp.next; // assuming that k will less than list size
        }

        while(fp.next != null){
            sp = sp.next;
            fp = fp.next;
        }

        ListNode newHead = sp.next;

        sp.next = null;
        fp.next = dummy.next;

        return newHead;
    }
    private int getSizeLL(ListNode node){
        int size = 0;
        while(node.next != null){
            node = node.next;
            size++;
        }
        return size;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
