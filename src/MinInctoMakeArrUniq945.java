import java.util.HashSet;
import java.util.Set;

public class MinInctoMakeArrUniq945 {

    public static void main(String[] args) {
        int[] arr = {15781,26207,24203,22558,22936,15256,4019,22296,16652,7753,14933,18082,12506};
        System.out.println(minIncrementForUnique(arr));
    }
    public static int minIncrementForUnique(int[] A) {
        Set<Integer> hs = new HashSet<>();
        int count =0;
        int max = A[0];
        for(int i=0;i<A.length;i++){
            int ele = A[i];
            if(hs.contains(A[i]) && i!=0){
                count+=max+1 - A[i];
                ele = max+1;
            }
            hs.add(ele);
            if(ele > max){
                max = ele;
            }
        }
        return count;
    }
}
