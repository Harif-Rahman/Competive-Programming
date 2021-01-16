package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String str = "abcharifcnc";
        System.out.println(lengthOfLongestSubstring1(str));
    }

    /**
     * WORKING
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int right = 0;right < s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(left <= right && map.get(s.charAt(right)) > 1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            max = Math.max(right-left+1,max);
        }
        return max;
    }
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


}
