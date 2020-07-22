import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FirsttMissingPostive {
    public static void main(String[] args) {
        int[] arr ={6,5,3,2,1};

        /*
        6 5 3 2 1
          |
        6 1 3 2 5
          |
        1 6 3 2 5
              |
        1 2 3 6 5
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);

        firstMissingPositive1(list);
    }
    /*
    Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3
Example 2:
Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:
Your algorithm should run in O(n) time and uses constant extra space.
     */
    /**
     * PERFECT TC :O(N) SC : O(1)
     * trick is to use the array length
     * if(number is greater than arr length or less than zero or in correct position then continue;
     * @param A
     * @return
     */
    public static int firstMissingPositive1(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length)
                i++;
            else{
                if(A[A[i]-1] != A[i]){
                    //swap because it is not in correct position
                    swap(A, i, A[i]-1);
                }else{
                    i++;
                }
            }
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * TC : O(N) SC :O(POSITVE ELEMENTS)
     * NOT RECOMMENED
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(i <=0){
                continue;
            }
            set.add(i);
            max = Math.max(max,i);
        }
        for(int i=1;i<max;i++){
            if(set.add(i)){
                return i;
            }
        }
        return max <= 0 ? 1 : max + 1;
    }

    /**
     * INTERVIWEBIT
     * @param A
     * @return
     */
    public static int firstMissingPositive1(ArrayList<Integer> A) {
        // 4 1 -1 3
        //1 1 1
        //1
        for(int i=0;i<A.size();i++){
            while(A.get(i) != i+1 && A.get(i) < A.size() && 1 <= A.get(i) && A.get(i) != A.get(A.get(i))){
                //swap
                int temp = A.get(i);
                // 3
                A.set(i,A.get(A.get(i))); //set [3,2,1,4,0]
                A.set(temp,A.get(temp));
            }
        }

        for(int i=0;i<A.size();i++){
            if(A.get(i) != i+1){
                return i+1;
            }
        }
        return A.size()+1;
    }


}
