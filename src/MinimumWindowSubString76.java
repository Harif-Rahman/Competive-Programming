import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {
    public static void main(String[] args) {
        String str = "bdab";
        String t = "ab";
        System.out.println(minWindow(str, t));
    }
    // S = "ADOBECODEBANC", T = "ABC"
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l = 0;
        int r = 0;
        String res = "";
        int count = 0;
        while(r < s.length()){












        }



        return res;
    }
}
