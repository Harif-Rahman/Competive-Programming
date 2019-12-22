import java.util.Map;
import java.util.TreeMap;

public class ArrayofDoubledPairs954 {
    public static void main(String[] args) {
        canReorderDoubled(new int[]{1,2,4,16,8,4});
    }
    public static boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }
}
