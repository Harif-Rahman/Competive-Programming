import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum18 {
    public static void main(String[] args) {
        int[] arr = {1,4,-1,0,-2,2,4,4};
        fourSum(arr,12);
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
}
