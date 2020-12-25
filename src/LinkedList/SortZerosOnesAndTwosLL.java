package LinkedList;

public class SortZerosOnesAndTwosLL {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next= new ListNode(1);
        listNode.next.next.next.next.next.next= new ListNode(1);
        listNode.next.next.next.next.next.next.next= new ListNode(2);
        listNode.next.next.next.next.next.next.next.next= new ListNode(2);
        sortLL(listNode);
    }

    // 1-1-1 2-2-2
    // 1 2 0 1 2 1 1 0 2

    private static ListNode sortLL(ListNode head){

        ListNode zerosD = new ListNode(-1);
        ListNode onesD = new ListNode(-1);
        ListNode twosD = new ListNode(-1);

        ListNode curr = head;

        ListNode zeros = zerosD;
        ListNode ones = onesD;
        ListNode twos = twosD;

        while (curr != null){
            if(curr.val == 0){
                zeros.next = curr;
                zeros = zeros.next;
            }else{
                if(curr.val == 1){
                    ones.next = curr;
                    ones = ones.next;
                }else{
                    twos.next = curr;
                    twos = twos.next;
                }
            }
            curr = curr.next;
        }
        zeros.next = onesD.next;
        ones.next = twosD.next;
       return  zeros == zerosD ? (onesD == ones ? twosD.next : onesD.next) : zerosD.next;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
