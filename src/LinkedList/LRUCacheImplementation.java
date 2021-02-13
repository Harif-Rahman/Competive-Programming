package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {
    public static void main(String[] args) {

       /*
["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

d <> 2 <> d
         */
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    /**
     * WORKING
     *tc : o(1)
     * sc : o(capacity)
     */
    static class LRUCache {
        Map<Integer,DLinkedList> map = null;
        int capacity;
        DLinkedList startDummy = new DLinkedList(-1,-1);
        DLinkedList lastDummy = new DLinkedList(-1,-1);

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
            startDummy.next = lastDummy;
            lastDummy.prev = startDummy;
        }

        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }
            DLinkedList res = map.get(key);
            moveElementToFirst(res);
            return res.val;
        }
        public void put(int key,int val){
            DLinkedList dl = new DLinkedList(key,val);
            if(map.containsKey(key)){
                map.get(key).val = val;
                moveElementToFirst(map.get(key));
            }else{
                if(map.size() == capacity){
                    removeElementFromLast();
                }
                addElementToFirst(dl);
                map.put(key,dl);
            }
        }
        private void removeElementFromLast(){
            // d<->3<->1<->d
            DLinkedList toRemove = lastDummy.prev;
            map.remove(toRemove.key);
            DLinkedList  first = lastDummy.prev.prev;
            first.next = lastDummy;
            lastDummy.prev = first;
        }
        private void addElementToFirst(DLinkedList dl){
            DLinkedList next = startDummy.next;
            startDummy.next = dl;
            dl.prev = startDummy;
            dl.next = next;
            next.prev = dl;
        }

        private void moveElementToFirst(DLinkedList dl){
            // if this key is already a first element then don't do anything
            // d <-> a <> b <> d
            if(startDummy.next.key == dl.key){
                return;
            }

            dl.next.prev = dl.prev;
            dl.prev.next = dl.next;
            DLinkedList next = startDummy.next;
            startDummy.next = dl;
            dl.prev = startDummy;
            dl.next = next;
            next.prev = dl;
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
    }
}

