import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "bca";

        findAnagrams(s,p);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        p = new String(pArr);
        int fp = 0; //first pointer
        int sp = p.length()-1; // second pointer
        char[] arr = new char[26];
        for(int i=0;i<p.length() && i < s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        if(new String(arr).equals(p)){
            ls.add(0);
        }
        while(sp + 1<s.length()){
            arr[s.charAt(fp) - 'a']--;
            fp++;
            sp++;
            arr[s.charAt(sp) - 'a']++;
            String str =  new String(arr);
            if(str.equals(p)){
                ls.add(fp);
            }
        }
        return ls;
    }
    public static List<Integer> findAnagrams1(String s, String p) {
            List<Integer> ls = new ArrayList<>();
            char[] c = p.toCharArray();
            Arrays.sort(c);
            String res = new String(c);
            int len = p.length()-1;
            int i=0;
            int j=len+i;
            char[] arr ;
            while(j<s.length()){
                arr = s.substring(i,j+1).toCharArray();
                Arrays.sort(arr);
                String str = new String(arr);
                if(str.equals(res)){
                    ls.add(i);
                }
                i++;
                j++;
            }
            return ls;
    }
}
