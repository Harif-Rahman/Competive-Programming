import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class FrequencySortCharacters451 {
    public static void main(String[] args) {
        frequencySort3("abbcccddddeeeee");
    }

    /**
     * TIME LIMIT EXCEEDED
     *
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        TreeMap<Integer, List<Character>> tm = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            tm.putIfAbsent(entry.getValue(), new LinkedList<>());
            tm.get(entry.getValue()).add(entry.getKey());
        }
        String res = "";
        while (tm.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tm.pollLastEntry();
            for (char c : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    res += c;
                }
            }
        }
        return res;
    }

    public static String frequencySort1(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        pq.addAll(hm.entrySet());
        StringBuilder res = new StringBuilder();
        while (pq.size() > 0) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char c = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }
    public static String frequencySort3(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1.getValue() > o2.getValue()){
                return -1;
            }
            if(o1.getValue() < o2.getValue()){
                return 1;
            }
            return 0;
        }));
        pq.addAll(hm.entrySet());
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.remove();
            int count = entry.getValue();
            char c = entry.getKey();
            while(count-- > 0){
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /**
     * BUCKET SORTING TECHNIQUE
     *
     * @param s
     * @return
     */
    public static String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < map.get(c); i++)
                        sb.append(c);

        return sb.toString();
    }

    class Entry {
        char c;
        int count;

        public Entry() {
            this.count = 0;
        }
    }

    /**
     * looks gud  as it is efficent
     * @param s
     * @return
     */
    public String frequencySortEfficent(String s) {

        Entry[] elems = new Entry[256];
        for (int i = 0; i < 256; i++) {
            elems[i] = new Entry();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            elems[c].c = c;
            elems[c].count++;
        }

        Arrays.sort(elems, (e1, e2) -> {
            return e2.count - e1.count; // descending order
        });

        StringBuilder result = new StringBuilder();
        for (Entry e : elems) {
            while (e.count-- > 0)
                result.append(e.c);
        }

        return result.toString();

    }
}
