package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {
    public static void main(String[] args) {

       /*
["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         */
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
    static class LRUCache {
        Map<Integer,DLinkedList> map = null;
        int capacity;
        DLinkedList startDummy = new DLinkedList(-1,-1);
        DLinkedList lastDummy = new DLinkedList(-1,-1);
        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                DLinkedList curr = map.get(key);
                moveToLast(curr);
                return curr.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            DLinkedList dnew = new DLinkedList(key,value);
            if(map.size() == 0){
                // attach to dummy nodes
                startDummy.next = dnew;
                dnew.prev = startDummy;
                dnew.next = lastDummy;
                lastDummy.prev = dnew;
                map.put(key,dnew);
            }
            else{
                if(map.containsKey(key)){
                    map.get(key).val = value;
                    moveToLast(map.get(key));
                }else{
                    if(map.size() >= capacity){
                        evict();
                    }
                    addNodeToLast(dnew);
                    map.put(key,dnew);
                }
            }
        }
        public void evict(){
            DLinkedList firstNode = startDummy.next;
            map.remove(firstNode.key);
            removeFirstNode();
        }
        public void removeFirstNode(){
            if(startDummy.next == lastDummy.prev){
                // then there is only node
                startDummy.next = lastDummy;
                lastDummy.prev = startDummy;
            }else{
                DLinkedList start = startDummy.next;
                startDummy.next = start.next;
                start.next.prev = startDummy;
            }
        }
        public void moveToLast(DLinkedList dll){
            // if it is start
            if(startDummy.next == lastDummy){
                // then there is one node
                // so dont do anything
                startDummy.next = dll;
                dll.prev = startDummy;
                dll.next = lastDummy;
                lastDummy.prev = dll;
            }else{
                // one element in between then don't do  anything
                if(startDummy.next != lastDummy.prev){
                    DLinkedList start = startDummy.next;
                    DLinkedList end = lastDummy.prev;
                    if(dll == start){
                        startDummy.next = dll.next;
                        dll.next.prev = start;
                        end.next = dll;
                        dll.prev = end;
                        dll.next = lastDummy;
                        lastDummy.prev = dll;
                    }else{
                        if(dll != end){
                            dll.prev.next = dll.next;
                            dll.next.prev = dll.prev;
                            end.next = dll;
                            dll.prev = end;
                            dll.next = lastDummy;
                            lastDummy.prev = dll;
                        }
                    }
                }
            }
        }
        public void addNodeToLast(DLinkedList dnew){
            // single node condiition
            if(startDummy.next == lastDummy){
                // no element in between
                startDummy.next = dnew;
                dnew.prev = startDummy;
                dnew.next = lastDummy;
            }else{
                DLinkedList end = lastDummy.prev;
                end.next = dnew;
                dnew.prev = end;
                dnew.next = lastDummy;
                lastDummy.prev = dnew;
            }
        }

        class DLinkedList{
            DLinkedList prev;
            DLinkedList next;
            int key;
            int val;
            DLinkedList(int key,int val){
                this.key = key;
                this.val = val;
            }
        }

        /**
         * good solution
         */
        class LRUCache1 {

            class Node {
                int key;
                int val;
                Node next;
                Node prev;
                Node(int key, int val) {
                    this.key = key;
                    this.val = val;
                }
            }

            Map<Integer, Node> map = new HashMap<>();

            // the least recently used key is sorted from last to first
            Node first = null;
            Node last = null;

            int capacity;

            public LRUCache1(int capacity) {
                this.capacity = capacity;
            }

            public int get(int key) {
                if (map.containsKey(key)) {
                    Node node = map.get(key);
                    deleteNode(node);
                    insertToHead(node);
                    return node.val;
                } else {
                    return -1;
                }
            }

            public void put(int key, int value) {
                if (map.containsKey(key)) {
                    deleteNode(map.get(key));
                } else {
                    if (map.size() == this.capacity) {
                        Node q = last;
                        deleteNode(q);
                        map.remove(q.key);
                    }
                }
                Node newNode = new Node(key, value);
                insertToHead(newNode);
                map.put(key, newNode);
            }

            public void deleteNode(Node node) {
                if (first == node && last == node) { //  only 1 node in double linked list
                    first = null;
                    last = null;
                } else if (first == node) {
                    // >= 2 nodes in double linked list
                    // & node == first
                    first = first.next;
                    first.prev = null;
                } else if (last == node) {
                    // >= 2 nodes in double linked list
                    // & node == last
                    last = last.prev;
                    last.next = null;
                } else {
                    //  >= 3 nodes in double linked list
                    // & node != first & node != last
                    Node prevNode = node.prev;
                    Node nextNode = node.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                }
            }

            public void insertToHead(Node node) {
                if (first == null) {
                    first = node;
                    last = node;
                } else {
                    first.prev = node;
                    node.next = first;
                    first = node;
                }
            }
        }
    }
}

