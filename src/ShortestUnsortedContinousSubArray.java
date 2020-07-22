import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestUnsortedContinousSubArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 11, 4, 11, 11, 20, 10, 11, 11, 20, 14, 11, 20, 20};
        /*
        2, 6, 4, 8, 10, 9, 15
           l            r
            l r
         */
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(1);
        ls.add(10);
        ls.add(10);
        ls.add(15);
        ls.add(10);
        ls.add(15);
        ls.add(10);
        ls.add(10);
        ls.add(15);
        ls.add(10);
        ls.add(15);

        System.out.println(findUnsortedSubarray(arr));
    }
    public static int printMaxLengthSubarray(int[] array) {

        int n = array.length;

        // From the beginning of the array, move to element in the array up to which the elements are sorted i.e. where array[i] > array[i+1]. Set startIndex = i.
        int startIndex = 0;
        for (int i = 0; i < n-1; i++) {
            if(array[i] > array[i+1]) {
                startIndex = i;
                break;
            }
        }

        // From the end of the array, move to the element up to which the elements are sorted in reverse order i.e. where array[j-1] > array[j]. Set endIndex = j.
        int endIndex = 0;
        for (int j = n-1; j > 0; j--) {
            if(array[j-1] > array[j]) {
                endIndex = j;
                break;
            }
        }

        // Find the minimum and maximum element in the sub array from startIndex to endIndex.
        int maxElement = array[startIndex];
        int minElement = array[startIndex];
        for (int i = startIndex+1; i <= endIndex; i++) {
            if(maxElement < array[i]) {
                maxElement = array[i];
            }
            if(minElement > array[i]) {
                minElement = array[i];
            }
        }

        // Search the sorted array from 0 to startIndex to find the index at which minimum element will be in sorted array say, minIndex.
        int minIndex = findMinIndex(array, minElement, startIndex);

        // Search the sorted array from endIndex to end of array to find the index at which maximum element will be in sorted array say, maxIndex.
        int maxIndex = findMaxIndex(array, maxElement, endIndex);

        // Sub array between minIndex to maxIndex is the required sub array.
        if(minIndex == maxIndex) {
            System.out.println("The array is already sorted.");
            return 0;
        }
        for (int i = minIndex; i <= maxIndex; i++) {
            System.out.print(array[i] + " ");
        }
        return maxIndex - minIndex+1;
    }

    private static int findMinIndex(int[] array, int minElement, int startIndex) {
        for(int i = 0; i < startIndex; i++) {
            if(minElement < array[i]) {
                return i;
            }
        }
        return startIndex;
    }

    private static int findMaxIndex(int[] array, int maxElement, int endIndex) {
        for(int i = array.length-1; i > endIndex; i--) {
            if(maxElement > array[i]) {
                return i;
            }
        }
        return endIndex;
    }


    /**
     * ME TC : O(N) NO OF ELEMENTS I ARRAY
     * SC : O(1)
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            while(left < nums.length-1 && nums[left]  <= nums[left+1]){
                left++;
            }
            while(right > 0 && nums[right-1] <= nums[right]){
                right--;
            }
            if(left >= right){
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = left ;i<=right;i++){
                min = Math.min(min,nums[i]);
                max = Math.max(max,nums[i]);
            }
            while(left > 0 && nums[left-1] > min){
                min = Math.min(min,nums[left]);
                left--;
            }

            while(right < nums.length-1 && nums[right+1] < max){
                max = Math.max(max,nums[right]);
                right++;
            }
            return right-left+1;
    }
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>(2);
        int left=0;
        for(left=0;left+1<A.size();left++){
            if(A.get(left) > A.get(left+1)){
                break;
            }
        }
        int right = A.size()-1;
        for(right=A.size()-1;right > 0;right--){
            if(A.get(right-1) > A.get(right)){
                break;
            }
        }

        if(left > right){
            res.add(-1);
            return res;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = left;
        int j = right;
        while(i <= j){
            min = Math.min(A.get(i),min);
            max = Math.max(A.get(j),max);
            i++;
        }
        //System.out.println("left "+left+" right "+right);
        while(left -1 > 0 && A.get(left-1) > min){
            min = Math.min(min,A.get(left));
            left--;
        }
        while(right+1 < A.size() && A.get(right+1) < max){
            max = Math.max(max,A.get(right));
            right++;
        }


        if(left >= 0 && right < A.size()){
            res.add(left);
            res.add(right);
        }else{
            res.add(-1);
        }
        return res;
    }
}
