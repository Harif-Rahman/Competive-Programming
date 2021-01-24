package Array;

import java.util.HashMap;
import java.util.Map;

public class checkArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = new int[][]{
                {78},
                {4,64,5},
                {91}
        };
        System.out.println(canFormArray(arr, pieces));
    }

    /**
     * tc : o(arr length)
     * sc :  o(no of pieces)
     * @param arr
     * @param pieces
     * @return
     */
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> map = new HashMap<>();

        for(int[] piece : pieces){
            map.put(piece[0],piece);
        }

        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                return false;
            }
            int[] pArr = map.get(arr[i]);
            int pInd = 0;
            if(pArr != null){
                // iterate piece list
                while(i < arr.length && pInd <pArr.length){
                    if(pArr[pInd] != arr[i]){
                        return false;
                    }
                    i++;
                    pInd++;
                }
            }
            if(pInd > 0){
                // if while loop triggered then we need to decrement i
                i--;
            }
        }
        return true;
    }
}
