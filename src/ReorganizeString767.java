import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorganizeString767 {
    public static void main(String[] args) {
        reorganizeString("ogccckcwmbmxtsbmozli");
    }

    /**
     * WORKING BUT NOT A GOOD ONE
     *
     * @param S
     * @return
     */
    public static String reorganizeStringmine(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int frequcency = map.getOrDefault(c, 0);
            if (frequcency > S.length() / 2) {
                return ""; // if frequency is greater than S length then we can't reorganize
            }
            map.put(c, frequcency + 1);
        }

        int size = S.length() / 2 + 3; // extra buffer
        List<Character>[] bucket = new List[size];


        for (Character c : map.keySet()) {
            int frequency = map.get(c);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(c);
        }

        char[] arr = new char[S.length()];

        int i = 0;
        for (int p = size - 1; p >= 0; p--) {
            List<Character> ls = bucket[p];
            if (ls != null) {
                for (char c : ls) {
                    int count = p;
                    while (i < S.length() && count > 0) {
                        arr[i] = c;
                        count--;
                        if (i > 0 && arr[i - 1] == arr[i]) {
                            return "";
                        }
                        i += 2;
                        if (i >= S.length()) {
                            i = 1;
                        }
                    }
                    if (count > 0) {
                        return "";
                    }
                    if (i >= S.length()) {
                        i = 1;
                    }
                }
            }
        }
        return new String(arr);
    }

    /*
    WORKING AND MOST VOTED SOLUTION
     */
    public static String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}
