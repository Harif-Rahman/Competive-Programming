package LinkedList;

public class OddEvenLinkedList328 {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
      //  ls.next.next.next.next = new ListNode(5);
        oddEvenList(ls);
    }

    /*
    having a odd pointer to the odd element and even pointer to the even element
    eventaully point odd initila
     */
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next = evenHead;// point odd last element to the even head beginning
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
