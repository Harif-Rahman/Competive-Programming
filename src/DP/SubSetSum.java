package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubSetSum {
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        System.out.println(solve(ls,5));
    }
    static Map<String,Boolean> map = new HashMap<>();
    public static int solve(ArrayList<Integer> A, int B) {
        return subsetExist(A,B,0) ? 1 : 0;

    }
    public static boolean subsetExist(ArrayList<Integer> A, int b, int level){
        if(b == 0){
            return true;
        }
        if(b < 0){
            return false;
        }
        if(level >= A.size()){
            return false;
        }
        String dpStr = level+"->"+b;

        if(map.containsKey(dpStr)){
            return map.get(dpStr);
        }


        boolean include = subsetExist(A,b-A.get(level),level+1);
        boolean exclude = subsetExist(A,b,level+1);
        map.put(dpStr,include || exclude);
        return include || exclude;
    }
}
