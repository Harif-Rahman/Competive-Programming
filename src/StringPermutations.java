import java.util.*;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        Set<String> permutationSet = new HashSet<>();
        getPermutations(str,0,"",permutationSet);
        System.out.println(permutationSet);
    }
    private static void getPermutations(String str,int start,String currStr,Set<String> permutationSet){
        if(str.length() == currStr.length()){
            permutationSet.add(new String(currStr));
        }else{
            for(int i=start;i<str.length();i++){
                swap(str,start,i);
                getPermutations(str,start+1,currStr,permutationSet);
                swap(str,start,i);
            }
        }
    }
    private static void swap(String str,int i,int j){
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
