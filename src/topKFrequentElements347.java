import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class topKFrequentElements347 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3};
        topKFrequentElements2(arr,2);
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
    private static List<Integer> topKFrequentElements1(int[] nums,int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        List<Map.Entry<Integer, Integer>> ls = new ArrayList<>(map.entrySet());
        ls.sort((o1, o2) -> (o2.getValue().compareTo(o1.getValue())));
        List<Integer> res = new ArrayList<>();
        int i=0;
        while (res.size() < k){
            res.add(ls.get(i++).getKey());
        }
        return res;
    }
    public static List<Integer> topKFrequentElements2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }

    /**
     * WORKING
     * TC : o(nums)
     * SC : o(nums)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentUsingBucketSort(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return null;
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i: nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            int key = entry.getKey();
            int frequency = entry.getValue();
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] res = new int[k];
        int resi = 0;
        for(int i=nums.length;i> 0 && resi < k;i--){
            if(bucket[i] != null){
                int size = bucket[i].size();
                int j = 0;
                while(resi < k && j < size){
                    res[resi++] = bucket[i].get(j++);
                }
            }
        }
        return res;
    }

}
