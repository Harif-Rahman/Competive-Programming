public class InsertionSortLL147 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(1);
        listNode.next.next= new ListNode(3);
        listNode.next.next.next= new ListNode(2);
        listNode.next.next.next.next= new ListNode(4);
        listNode.next.next.next.next.next= new ListNode(0);
        System.out.println(insertionSortLL(listNode));
    }
    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode insertionSortLL(ListNode head){
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(-1); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
