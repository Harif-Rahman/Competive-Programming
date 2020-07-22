import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistantBarcodes1054 {
    /*
    In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.



Example 1:

Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]


Note:

1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000
     */
    public static void main(String[] args) {

    }

    /**
     * TC : TOT LENGTH OF ARRAY
     * SC : O(TOT.LENGTH OF ARRAY)
     * @param barcodes
     * @return
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : barcodes){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[barcodes.length+1];
        for(Integer key : map.keySet()){
            if(bucket[map.get(key)] == null){
                bucket[map.get(key)] = new ArrayList<>();
            }
            bucket[map.get(key)].add(key);
        }
        int pointer = 0;
        int[] res = new int[barcodes.length];
        int totLen = 0;
        for(int i=bucket.length-1;i>=0 && totLen < bucket.length;i--){
            //most frequent element
            List<Integer> frequentElements = bucket[i];
            if(frequentElements != null && frequentElements.size() > 0){
                int size = frequentElements.size();
                int ind = 0;
                while (ind < size){
                    int count = i;
                    int currEle = frequentElements.get(ind);
                    while(count-- > 0){
                        res[pointer] = currEle;
                        totLen++;
                        pointer+=2;
                        if(pointer % 2 == 0 && pointer >= barcodes.length){
                            pointer = 1;
                        }
                    }
                    ind++;
                }
            }
        }
        return res;
    }

}
