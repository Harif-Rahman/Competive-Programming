public class ReverseLL {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        reverseLLIter(ls);
        System.out.println(ls);
    }
    //TODO learn this
/*    private static ListNode reverseLLUsingRecursion(ListNode head){
        if(head==null || head.next == null)
            return head;
        ListNode p = reverseLL(head.next);
        head.next.next = head;//n+1 th node pointing nth node
        head.next = null;
        return p;
    }*/
    private static ListNode reverseLLIter(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
