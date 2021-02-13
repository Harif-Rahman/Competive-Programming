package DFS;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumeber17 {
    public static void main(String[] args) {
        letterCombinations("234");
    }
    static List<String> res = new ArrayList<>();
    static String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","xyz"};
    public static List<String> letterCombinations(String digits) {
        //23
        helper(digits,"",0);
        return res;
    }

    /**
     * backtracking approach
     *
     * tc : branches will go upto the length 4 so 4 ^ digits length
     *

     * @param digits
     * @param str
     * @param ind
     */
    private static void helper(String digits,String str,int ind){
        if(ind == digits.length()){
            res.add(str);
            return;
        }
        for(int i=0;i<arr[digits.charAt(ind)-'0'].length();i++){
            helper(digits,str + arr[digits.charAt(ind)-'0'].charAt(i),ind+1);
        }
    }
}
