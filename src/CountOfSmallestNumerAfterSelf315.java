import java.util.ArrayList;
import java.util.List;
//man


public class CountOfSmallestNumerAfterSelf315 {
    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        countSmaller(arr);
    }

    /**
     * ACCEPTED NEED TO BE IMPROVED
     * TC : N * (LOGN + N )
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int[] res = new int[nums.length];
        for(int i=nums.length-1;i >= 0;i--){
            int ind = findIndexToBeInserted(ls,nums[i]);
            if(ind < ls.size()){
                ls.add(ind,nums[i]);
            }else{
                ls.add(nums[i]);
            }
            int countOfSmallestNumberAfterSelf = bS(ls,nums[i]);
            res[i] = countOfSmallestNumberAfterSelf;
        }
        List<Integer> out = new ArrayList<>();
        for(int i=0;i<res.length;i++){
            out.add(res[i]);
        }
        return out;
    }
    // 1 2 3 5 6
    private static int bS(List<Integer> ls,int num){
        int low = 0;
        int high = ls.size()-1;
        int maxInd = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(ls.get(mid) == num){
                maxInd = mid;
            }
            if(ls.get(mid) < num){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return maxInd;
    }
    // 1  6
    private static int findIndexToBeInserted(List<Integer> ls,int num){
        int low = 0;
        int high = ls.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(ls.get(high) <= num){
                return high+1;
            }
            if(ls.get(mid) < num){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
