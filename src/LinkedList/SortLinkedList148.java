package LinkedList;

import java.util.List;

public class SortLinkedList148 {
    /*


    4  >   2  >  1  > 3
     lm    r

     4 > 2
     l   r

     2 > 4


     */

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode res = sort(node);
        System.out.println(res);
    }

    /**
     * WORKING
     *
     * CODE AGAIN
     * @param left
     * @return
     */
    private static ListNode sort(ListNode left){
        if(left == null || left.next == null){
            return left;
        }
        ListNode sp = left;
        ListNode fp = left;
        ListNode prev = null;
        while(fp != null && fp.next != null){
            prev = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        prev.next = null;
        ListNode l1 = sort(left);
        ListNode l2 = sort(sp);
        return  mergeLL(l1,l2);

    }
    private static ListNode mergeLL(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode newNode = dummy;
        while(left != null && right != null){
            if(left.val > right.val){
                newNode.next = right;
                right = right.next;
            }else{
                newNode.next = left;
                left = left.next;
            }
            newNode = newNode.next;
        }
        if(left != null){
            newNode.next = left;
        }
        if(right != null){
            newNode.next = right;
        }
        return dummy.next;
    }
}
