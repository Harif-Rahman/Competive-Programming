public class RemoveDupFromSortedListll82 {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(1);
        ls.next.next = new ListNode(2);
        ls.next.next.next = new ListNode(2);
        ls.next.next.next.next = new ListNode(2);
        ls.next.next.next.next.next = new ListNode(3);
        ls.next.next.next.next.next.next = new ListNode(3);
        ls.next.next.next.next.next.next.next = new ListNode(4);
        deleteDuplicates1(ls);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        int currVal = -128;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while(curr!= null){
            if(curr.next != null && curr.val == curr.next.val){
                currVal = curr.val;
                curr = curr.next.next;
                prev.next = curr;
            }else{
                if(currVal == curr.val){
                    prev.next = curr.next;
                    curr = prev.next;
                }else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){//if there is no iterations
                pre=pre.next;
            }
            else{ //found duplicate removed one more duplicate
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
