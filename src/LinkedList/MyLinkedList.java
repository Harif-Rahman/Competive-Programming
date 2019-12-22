package LinkedList;

class MyLinkedList {
    Node head;
    private static int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if(index >= size) return -1;

        Node current = head;
        for (int i = 0; i < index ; i++) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }


    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if(head == null)
            head = new Node(val);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == 0){
            addAtHead(val);
            return;
        }
        int currentInd = 0;
        Node current = head;
        while (currentInd++ < index - 1){
            current = current.next;
        }
        Node node = new Node(val);
        node.next = current.next;
        current.next = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
    }
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        myLinkedList.get(5);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
    /*
    ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
            [[],           [2],     [1],            [2],        [7],        [3],        [2],        [5],        [5],    [5],    [6],                [4]]
     */
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
