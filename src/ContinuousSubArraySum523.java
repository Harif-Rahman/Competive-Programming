import java.util.HashSet;
import java.util.Set;

public class ContinuousSubArraySum523 {
    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(isSubArraysumModk(arr, 0));
    }
    private static boolean isSubArraysumModk(int[] arr,int k){
        for (int i : arr) {

        }
        if(k == 0)
            return true;
        if(k < 0){
            k = -k;
        }
        if(arr.length == 1){
            return false;
        }

        Set<Integer> hs =new HashSet<>();
        hs.add(0);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hs.contains(sum-k) && (sum-(sum-k)) % k == 0){
                return true;
            }
            hs.add(sum);
        }
        return false;
    }
}
