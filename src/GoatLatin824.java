import java.util.Arrays;
import java.util.HashSet;

public class GoatLatin824 {
    public static void main(String[] args) {
        String str = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin1(str));
    }
    private static String toGoatLatin(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitArr = S.split("\\s");
        StringBuilder suffix = new StringBuilder("a");
        for(int i=0;i<splitArr.length;i++){
            StringBuilder sb = new StringBuilder(splitArr[i]);
            char c = splitArr[i].charAt(0);
            if(isVowel(c)){
                sb.append("ma");
            }else{
                sb.deleteCharAt(0);
                sb.append(splitArr[i].charAt(0)+ "ma").append(suffix);
            }
            suffix.append("a");
            stringBuilder.append(sb.toString());
            if(i != splitArr.length -1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
    ||  (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String toGoatLatin1(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");

        for (String w : S.split(" ")) {
            if (sb.length() != 0) {
                sb.append(" ");
            }

            char fChar = w.charAt(0);
            if (vowels.contains(fChar)) {
                sb.append(w);
            } else {
                sb.append(w.substring(1));
                sb.append(fChar);
            }

            sb.append("ma").append(suffix);

            suffix.append("a");
        }

        return sb.toString();
    }
}
// "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"