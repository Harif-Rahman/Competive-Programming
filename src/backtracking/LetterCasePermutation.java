package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> res= new ArrayList<>();
        char[] ch = S.toCharArray();
        backtracking(ch,0,res);
        return res;
    }
    private static void backtracking(char[] ch,int ind,List<String> ls){
        if(ind == ch.length){
            ls.add(new String(ch));
            return;
        }else{
            for(int i=ind;i<ch.length;i++){
                char temp = ch[i];
                if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')){
                    if(ch[i] >= 'a'){
                        //lower case convert to uc
                        ch[i] = (char)((int)ch[i] - 32);
                    }else{
                        //upper case convert to lc
                        ch[i] = (char)((int)ch[i] + 32);
                    }
                }
                backtracking(ch,i+1,ls);
                ch[i] = temp;//backtrack
            }
        }
    }
}
