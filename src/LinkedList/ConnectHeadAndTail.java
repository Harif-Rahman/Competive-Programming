package LinkedList;
/*
Given a singly linked list like a-b-c-d-e-f-g , connect one from head and from tail and your final list will be like this: a-g-b-f-c-e-d
a-b-c-d-e-f-g
g->f>e>d>c>b>a
a > b > c
c > b > a


a > c > b

a > c > b > b >
f > e > d > c > b >a
 */
public class ConnectHeadAndTail {
    /***
     * reverse the node and then connect
     *
     * TC : o(n) for reverse + O(n) for connecting
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = new ListNode('a');
        node.next = new ListNode('b');
        node.next.next = new ListNode('c');
        node.next.next.next = new ListNode('d');
        node.next.next.next.next = new ListNode('e');
        node.next.next.next.next.next = new ListNode('f');
        node.next.next.next.next.next.next = new ListNode('g');
        ListNode cloneDummyHead = new ListNode('%');
        ListNode cloneHead = cloneDummyHead;

        ListNode curr = node;
        while (curr != null){
            // if both nodes are pointing to same node then break
            cloneHead.next = new ListNode(curr.c);
            cloneHead = cloneHead.next;
            curr = curr.next;
        }
        cloneDummyHead = reverse(cloneDummyHead.next);
        ListNode res = node;
        while (node != null){
            if(node.c == cloneDummyHead.c){
                node.next = null;
                cloneDummyHead.next = null;
                break;
            }
            ListNode next = node.next;
            ListNode cloneNext = cloneDummyHead.next;
            node.next = cloneDummyHead;
            cloneDummyHead.next = next;
            node = next;
            cloneDummyHead = cloneNext;
        }
        System.out.println(res);
    }

    /**
     *  b > a > null
     *
     *                   b       c   > d
     *                 prev     node
     *
     *
     *
     * @param node
     */
    private static ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode next = null;

        while (node != null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    static class ListNode{
        char c;
        ListNode next;

        public ListNode(char c) {
            this.c = c;
        }
    }
}
