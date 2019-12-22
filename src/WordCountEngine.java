import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class WordCountEngine {
    static String tokenizeString(String str) {
        int len = str.length();
        String result = "";

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            // upper-case
            if (c >= 65 && c <= 90) {
                c += 32;
                result += c;
            }
            // lower-case
            else if (c >= 97 && c <= 122) {
                result += c;
            }
            // space
            else if (c == 32) {
                if (result.charAt(result.length()-1) != 32) {
                    result += c;
                }
            }
            // anything else
            else {
                continue;
            }
        }

        return result;
    }

    static String[][] wordCountEngine(String document) {
        document = tokenizeString(document);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String str = "";
        int length = document.length();
        int maxCount = 0;

        for (int i = 0; i < length; i++) {
            char c = document.charAt(i);
            int count = 0;
            if (c == 32) {
                count = addToHash(hm, str);
                str = "";
            } else if (i == length-1) {
                str += c;
                count = addToHash(hm, str);
            } else {
                str += c;
            }

            maxCount = Math.max(maxCount, count);
        }

        ArrayList<ArrayList<String>> bucketList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < maxCount + 1; i++) {
            bucketList.add(new ArrayList<String>());
        }

        for (String key : hm.keySet()) {
            int count = hm.get(key);
            bucketList.get(count).add(key);
        }

        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i), String.CASE_INSENSITIVE_ORDER);
        }

        String[][] result = new String[hm.size()][2];
        int index = 0;
        for (int i = maxCount; i > 0; i--) {
            for (int j = 0; j < bucketList.get(i).size(); j++) {
                result[index][0] = bucketList.get(i).get(j);
                result[index++][1] = Integer.toString(i);
            }
        }


        return result;
    }

    private static int addToHash(HashMap<String, Integer> hm, String key) {
        int count = 0;
        if (hm.containsKey(key)) {
            count = (int) hm.get(key) + 1;
            hm.put(key, count);
        } else {
            count = 1;
            hm.put(key, count);
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        wordCountEngine(str);

    }

}
