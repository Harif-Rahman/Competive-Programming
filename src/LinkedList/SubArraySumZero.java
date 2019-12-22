package LinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumZero {
    public static void main(String[] args) {
    int[] arr = {3, 2,  5  ,-7  ,2, -1};
    //           0 ,3  ,5   10, 3  5
        //          |           |
        System.out.println(Arrays.toString(zeroSumSubArray(arr)));
    }
    /*
    storing the sum of previous range of elements ,when we encounter the same sum again then we have the range
     */
    private static int[] zeroSumSubArray(int[] arr){
        int sum =0;
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i =0;i<arr.length; i++) {
            Integer prevStoredSumIndex = hm.get(sum);
            if(prevStoredSumIndex == null){
                hm.put(sum,i);
                sum+=arr[i];
            }else {
                return Arrays.copyOfRange(arr,prevStoredSumIndex,i);
            }
        }
        return null;
    }


}
