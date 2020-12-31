import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BannedWords {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String maxFrequentWord = "";
        Map<String,Integer> frequencyMap = new HashMap<>();

        Set<String> bannedWords = new HashSet<>();
        int max = 0;
        for(String str : banned){
            str = str.toLowerCase();
            bannedWords.add(str);
        }
        paragraph = removePunctuationsAndConvertToLc(paragraph);
        for(String str : paragraph.split("[?'.\\s]")){
            if(!str.isEmpty() && !bannedWords.contains(str)){
                frequencyMap.put(str,frequencyMap.getOrDefault(str,0)+1);
                if(frequencyMap.get(str) > max){
                    maxFrequentWord = str;
                    max = frequencyMap.get(str);
                }
            }
        }
        return maxFrequentWord;
    }
    private static String removePunctuationsAndConvertToLc(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = Character.toLowerCase(str.charAt(i));
            if(c >= 'a' && c <= 'z'){
                sb.append(c);
            }else{
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * better solution
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord1(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String ban : banned){
            set.add(ban);
        }

        String[] words = paragraph.toLowerCase().split("[!?',;\\.\\s]");
        //System.out.println(Arrays.toString(words));
        Map<String, Integer> map  = new HashMap<>();
        for(String word : words ){
            word = word.trim();
            if(!set.contains(word) && !word.isEmpty()){
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }

        int max = 0; String fWord ="";
        for(String word: map.keySet()){
            if(map.get(word) > max){
                max = map.get(word);
                fWord = word;
            }
        }

        return fWord;
    }

    public static void main(String[] args) {
        String str = "a, a, a, a, b,b,b,c, c";
        mostCommonWord(str,new String[]{"a"});
    }
}
