package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String str = "dvdf";
        lengthOfLongestSubstring1(str);
    }

    /**
     * worst tc
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(hm.get(s.charAt(right)) != null && hm.get(s.charAt(right)) > 1){
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
    public static int lengthOfLongestSubstring1(String s) {
        //dvdf
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


}
