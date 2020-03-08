import java.util.HashMap;
import java.util.Map;
/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

/**
 * not yet solved
 */


/*  23 1  2   4  3  3  7
    0     i      j
    23 24 26  30 33 36 43
    23 1
    24 1
    26
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {23,1,2,4,3,3,7};

        System.out.println(subArraySumCount(arr, 6));
    }
    private static int subArraySumCount(int[] arr,int k){
        Map<Integer,Integer> map = new HashMap<>(); // to store the (sum,no of times the sum has occured)
        map.put(0,1);
        int result =0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                map.put(sum-k,map.getOrDefault(sum-k,1)+1);
            }
            map.put(sum,map.getOrDefault(sum,1));
        }
        return result;
    }
}
