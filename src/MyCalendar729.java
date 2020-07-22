import java.util.TreeMap;

public class MyCalendar729 {
    public static void main(String[] args) {
        MytreeMap mytreeMap = new MytreeMap();
        mytreeMap.book(10,20);
        mytreeMap.book(15,25);
        mytreeMap.book(9,13);
        mytreeMap.book(20,30);
        mytreeMap.book(10,20);
    }
    static class MytreeMap {
        /*



        5
        1 10

        if(1 <= 5 && 5 <= 10)
         */
        TreeMap<Integer,Integer> treeMap = null;
        public MytreeMap() {
            treeMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer floorKey = treeMap.floorKey(start);
            if (floorKey != null && treeMap.get(floorKey) > start) return false;
            Integer ceilingKey = treeMap.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return false;

            treeMap.put(start, end);
            return true;
        }
    }
}
