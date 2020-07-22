import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray1331 {
    public static void main(String[] args) {
        int[] arr = {40,10,10,20,30};
        arrayRankTransform(arr);
    }
    public static int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.putIfAbsent(arr[i],i);
        }
        int[] res = arr.clone();
        Arrays.sort(arr);
        int rank = 1;
        for(int i=0;i<arr.length;i++){
            res[hm.get(arr[i])] = rank;
            rank++;
        }
        return res;
    }
}
