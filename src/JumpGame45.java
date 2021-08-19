import java.util.LinkedList;
import java.util.Queue;

public class JumpGame45 {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        jump(arr);
    }

    /**
     * WORKING
     * @param A
     * @return
     */
    public static int jump(int[] A) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int level = 0;
        boolean[] visted = new boolean[A.length];
        visted[0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int p = 0;p<size;p++){
                int curr = queue.remove();
                for(int i=curr+1;i<=curr+A[curr];i++){
                    if(i < A.length && !visted[i]){
                        if(i == A.length-1){
                            return level + 1;
                        }
                        visted[i] = true;
                        queue.add(i);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
