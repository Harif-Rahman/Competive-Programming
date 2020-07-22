import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    /*
    658. Find K Closest Elements
Medium

1235

233

Add to List

Share
Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.



Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 10^4
Absolute value of elements in the array and x will not exceed 104
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        findClosestElements(arr,k,x);
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ind = bS(arr,x);
        System.out.println("ind --->"+ind);
        int i = ind-1;
        int j= ind;
        List<Integer> ls = new ArrayList<>();
        while(k-- > 0 && (i >= 0 || j < arr.length)){
            int dist1 = Integer.MAX_VALUE;
            int dist2 = Integer.MAX_VALUE;
            if(i >= 0){
                dist1 = Math.abs(x-arr[i]);
            }
            if(j < arr.length){
                dist2 = Math.abs(x-arr[j]);
            }
            System.out.println("dist1 >>"+dist1);
            System.out.println("dist2>>"+dist2);
            int lInd = ls.size()-1;
            if(dist1 <= dist2){
                if(ls.size() > 0 && ls.get(lInd) > arr[i]){
                    int temp = ls.get(lInd);
                    ls.set(lInd,arr[i]);
                    ls.add(temp);
                }else{
                    ls.add(arr[i]);
                }

                i--;
            }else{

                if(ls.size() > 0 && ls.get(lInd) > arr[j]){
                    int temp = ls.get(lInd);
                    ls.set(lInd,arr[j]);
                    ls.add(temp);
                }else{
                    ls.add(arr[j]);
                }
                j++;
            }
        }
        return ls;
    }
    private static int bS(int[] arr,int k){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                return mid;
            }
            if(arr[low] > k){
                return low;
            }

            if(arr[mid] < k){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

}
