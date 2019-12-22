/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

import java.util.HashMap;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] arr ={2,1,2,1,2,2,1};
        majorityElement1(arr);

    }

    /*
    having hash map to store the count
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>(nums.length+1,1);
        for(int i : nums){
            Integer res = hm.get(i);
            hm.put(i, res!= null ? res+1 :1);
            if(hm.get(i) > nums.length/2)
                return i;
        }
        return 0;
    }

    /*
    Boyer-Moore Majority Vote Algorithm
    1) set major as first element
    2) for 1 to n:
        1) if major == current element : count ++;
           else if count == 0 means the other element has the same count of current element  increase count
                else count--;
     */
    public static int majorityElement1(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
        }
        return major;
    }
}
