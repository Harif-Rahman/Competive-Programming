package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MergeSort {
    /*   public static void main(String[] args) {
           System.out.println(sortArray(new int[]{-4,0,7,4,9,-5,-1,0,-7,-1}));
       }*/
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }

    }

    private static void merge(int[] nums, int low, int mid, int right) {
        // [2,5]   [1,3]
        int first = low;
        int second = mid + 1;

        int[] tempArr = new int[right - low + 1];
        int tempArri = 0;
        while (tempArri < tempArr.length && first <= mid && second <= right) {
            if (nums[first] >= nums[second]) {
                //swap
                tempArr[tempArri++] = nums[second];
                second++;
            } else {
                tempArr[tempArri++] = nums[first];
                first++;
            }
        }
        while (tempArri < tempArr.length && first <= mid) {
            tempArr[tempArri++] = nums[first++];
        }
        while (tempArri < tempArr.length && second <= right) {
            tempArr[tempArri++] = nums[second++];
        }

        // copy all
        int ind = 0;
        for (int i = low; i <= right; i++) {
            nums[i] = tempArr[ind++];
        }
        System.out.println(nums);
    }
}
