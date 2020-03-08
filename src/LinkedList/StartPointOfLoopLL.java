package LinkedList;

public class StartPointOfLoopLL {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1); //  0 1 4 1 0
        ls.next = new ListNode(2); //fp
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        ls.next.next.next.next.next = new ListNode(6);
        ls.next.next.next.next.next.next = new ListNode(7);
        ls.next.next.next.next.next.next.next = new ListNode(8);
        ls.next.next.next.next.next.next.next.next = ls.next.next.next;
        getStartPoitOfLoop(ls);
    }
    private static ListNode getStartPoitOfLoop(ListNode head){
        ListNode tortoise = head; //slow pointer
        ListNode hare = head; //fast pointer
        do {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }while (tortoise != hare);

        tortoise = head;
        while (tortoise != hare){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
