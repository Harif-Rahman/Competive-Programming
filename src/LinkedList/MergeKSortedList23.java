package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList23 {
    public static void main(String[] args) {
        /*
        [
    1->4->5,
    1->3->4,
    2>6
]
         */
        ListNode[] listNodes = new ListNode[3];
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);
        listNodes[0] = first;
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);
        listNodes[1] = second;
        ListNode third = new ListNode(2);
        third.next = new ListNode(6);
        listNodes[2] = third;
        mergeKLists1(listNodes);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode res = dummy;
        while(true){
            int max = Integer.MIN_VALUE;
            for(ListNode node : lists){
                if(node != null){
                    max = Math.max(node.val,max);
                }
            }
            for(int i=0;i<lists.length;i++){
                ListNode node = lists[i];
                while(node != null && node.val <= max){
                    queue.add(node.val);
                    node = node.next;
                }
                lists[i] = node;
            }
            if(queue.isEmpty()){
                return res;
            }
            while(!queue.isEmpty()){
                dummy.next = new ListNode(queue.remove());
                dummy = dummy.next;
            }
        }
    }
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
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