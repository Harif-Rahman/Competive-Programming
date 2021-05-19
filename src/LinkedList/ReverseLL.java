package LinkedList;
// a->b->c->d->e
public class ReverseLL {
    public static void main(String[] args) {
        ListNode node = new ListNode('a');
        node.next = new ListNode('b');
        node.next.next = new ListNode('c');
        node.next.next.next = new ListNode('d');
        node.next.next.next.next = new ListNode('e');
        node.next.next.next.next.next = new ListNode('f');
        node.next.next.next.next.next.next = new ListNode('g');
        reverse(node,null);
        System.out.println(newHead);
    }
    static ListNode newHead = null;
    private static void reverse(ListNode node,ListNode prev){
        if(node == null){
            newHead = prev;
            return;
        }
        reverse(node.next,node);
        node.next = prev;
    }

    static class ListNode{
        char c;
        ListNode next;

        public ListNode(char c) {
            this.c = c;
        }
    }
}

