public class MinInRotatedSortedArray153  {
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
     */

    /**
     * solved myself
     * @param nums
     * @return
     */
    public int findMinIteratively(int[] nums) {
        int low=0;
        int high = nums.length-1;
        while(high-low > 1){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[high]){
                high = mid;
            }else{
                low = mid;
            }
        }
        return Math.min(nums[low],nums[high]);
    }
    public int finMinRecursively(int[] nums,int low,int high){
        if(low >=high && high - low < 1){
            return Math.min(nums[low],nums[high]);
        }
        int mid = low + (high-low)/2;
        if(nums[mid] < nums[high]){
            return finMinRecursively(nums,low,mid);
        }else{
            return finMinRecursively(nums,mid,high);
        }
    }

}
