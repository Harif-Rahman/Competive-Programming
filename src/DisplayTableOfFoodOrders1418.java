import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableOfFoodOrders1418 {
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        res.add(Arrays.asList("David","3","Ceviche"));
        res.add(Arrays.asList("Corina","10","Beef Burrito"));
        res.add(Arrays.asList("David","3","Fried Chicken"));
        res.add(Arrays.asList("Carla","5","Water"));
        res.add(Arrays.asList("Carla","5","Ceviche"));
        res.add(Arrays.asList("Rous","3","Ceviche"));
        displayTable(res);
    }
    public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, Map<String,String>> treeMap = new TreeMap<>();
        TreeSet<String> set = new TreeSet<>();
        for(List<String> ls : orders){
            Integer tableName = Integer.parseInt(ls.get(1));
            String foodName = ls.get(2);
            Map<String,String> hm ;
            hm = treeMap.computeIfAbsent(tableName,key -> new HashMap<>());

            int orderCount = (Integer.parseInt(hm.getOrDefault(foodName,"0"))) +1;
            hm.put(foodName,String.valueOf(orderCount));
            treeMap.put(tableName,hm);
            set.add(foodName);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>(set.size()+1);
        ls.add("Table");
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            ls.add(iterator.next());
        }
        res.add(ls);
        for(Integer tableName : treeMap.keySet()){
            List<String> tempList = new ArrayList<>(set.size()+1);
            tempList.add(String.valueOf(tableName));
            Map<String,String> map = treeMap.get(tableName);
            Iterator<String> iterator1 = set.iterator();
            while(iterator1.hasNext()){
                tempList.add(map.getOrDefault(iterator1.next(),"0"));
            }
            res.add(tempList);
        }
        return res;
    }
}
