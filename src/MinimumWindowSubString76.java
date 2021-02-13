import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(str, t));
    }
    // S = "ADOBECODEBANC", T = "ABC"

    /**
     * WORKING ONLY ONE CASE FAILING
     *TC : o(t) to build tmap and o(s)   that means because each character will be touched only twice o(t) to
     * o(t) + o(s)
     *
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        Map<Character,Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        int count = 0;
        int i=0;
        String res = s;

        Map<Character,Integer> smap = new HashMap<>();
        for(int j=0;j<s.length();j++){
            char currChar = s.charAt(j);

            if(tmap.containsKey(currChar)){
                if(smap.get(currChar) == null || smap.get(currChar) < tmap.get(currChar)){
                    count++;
                }
                smap.put(currChar,smap.getOrDefault(currChar,0)+1);
            }
            while(i < j && count == t.length()){
                int size = j-i+1;
                if(size < res.length()){
                    res = s.substring(i,j+1);
                }
                char sChar = s.charAt(i);
                if(tmap.containsKey(sChar)){
                    // impacting the window
                    if(smap.get(sChar) == tmap.get(sChar)){
                        count--;
                    }
                    smap.put(sChar,smap.get(sChar)-1);
                }
                i++;
            }
            }
        return res;
    }
}