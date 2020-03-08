import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        String[] str ={"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequentWords(str,2);
    }
    public static List<String> topKFrequentWords(String[] words, int k) {
        Map<String,Integer> hm = new HashMap<>();
        for(String str: words){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(k, (a,b) ->
                a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());
        List<String> ls = new ArrayList<>(k);
        while(k-- > 0){
            ls.add(pq.poll().getKey());
        }
        return ls;
    }
}
