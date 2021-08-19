import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum18 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        fourSum1(arr,8);
    }
    public static List<List<Integer>> fourSum(int[] arr, int s) {
        // running time: O(N^3)
        // total time: O(N ^ 3 + N log N)  = O(N ^ 3)
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<=arr.length-4;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)-1);
            for(int j=i+1;j<=arr.length-3;j++){
                map.put(arr[j],map.getOrDefault(arr[j],0)-1);
                for(int k=j+1;k<=arr.length-2;k++){
                    map.put(arr[k],map.getOrDefault(arr[k],0)-1);
                    int ele = arr[i]+arr[j]+arr[k];
                    int target = s-ele;
                    if(map.get(target) != null && map.get(target) > 0){
                        List<Integer> ls = new ArrayList<>(4);
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add(arr[k]);
                        ls.add(target);
                        res.add(ls);
                    }
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i-1 >= 0 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(j-1 >= 0 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                // do 2 sum
                int k = j+1;
                int l = nums.length-1;
                int sum = nums[i]+nums[j];
                int t = target - sum;
                while(k < l){
                    if(k != j+1 && k -1 >= 0 && nums[k] == nums[k-1]){
                        k++;
                        continue;
                    }
                    if(l != nums.length-1 && l+1 < nums.length && nums[l] == nums[l+1]){
                        l--;
                        continue;
                    }
                    if(nums[k] + nums[l] == t){
                        // found
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(nums[l]);
                        res.add(ls);
                    }
                    if(nums[k] + nums[l] < t){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return res;
    }
}
