import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArr26 {
    /*
    26. Remove Duplicates from Sorted Array
Easy

1943

4178

Add to List

Share
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
     */
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4};
        removeDuplicates1(arr);
    }
// 1 2 2 3 3 4
//     l
//     r
    public static int removeDuplicates1(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums.length;
        }

        int left = 1;
        for(int right = 1;right < nums.length;right++){
            if(nums[left-1] != nums[left]){
                nums[left] = nums[right];
                left++;
            }
        }
        return left+1;
    }











    public static int removeDuplicates(int[] nums) {
        int begInd = 0; //pointer which hold the initial pointer to store the unique elements
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] != nums[i+1]){
                begInd++;
                nums[begInd] = nums[i+1];
            }
        }
        return begInd+1;
    }
    public static int removeDuplicates(ArrayList<Integer> a) {
        int left = 1;
        int right =1;

        while(right < a.size()){
            if(!a.get(right).equals(a.get(right - 1))){
                a.set(left,a.get(right));
                left++;
            }
            right++;
        }
        return left;
    }

}
