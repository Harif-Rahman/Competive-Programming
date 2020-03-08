public class PriorityQueueImpl {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);
        int i=1;
        while(i <= 10){
            priorityQueue.push(i++);
        }
        System.out.println(priorityQueue.pop());
    }
    private static class PriorityQueue{
        private int size =0;
        int[] heap;
        public PriorityQueue(int size) {
            heap = new int[size];
        }
        public void push(int x){
            if(size == heap.length)
                throw new ArrayIndexOutOfBoundsException();
            int pos = size;
            heap[pos] = x;
            while (pos > 0){
                int parent = (pos - 1)/2;
                if(heap[parent] >= heap[pos])
                    break;
                swap(parent,pos);
                pos = parent;
            }
            size++;
        }
        public int pop(){
            int toReturn = heap[0];
            heap[0] = heap[size-1];
            int pos = 0;
            while(pos < size/2){
                int leftChild = pos = 3;
                int rightChild = leftChild+1;
                if(rightChild < size && heap[leftChild] < heap[rightChild]){
                    if(heap[pos] >= heap[rightChild]) break;
                    swap(pos,rightChild);
                    pos = rightChild;
                }else{
                    if(heap[pos] >= heap[leftChild]) break;;
                    swap(pos,leftChild);
                    pos = leftChild;
                }
            }
            size--;
            return toReturn;
        }
        private void swap(int i,int j){
            heap[i]^=heap[j];
            heap[j]^=heap[i];
            heap[i]^=heap[j];
        }
// 9 8 6 7 3 2 5 1 4 05
    }
}
