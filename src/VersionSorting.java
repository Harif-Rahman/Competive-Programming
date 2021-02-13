import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VersionSorting {
    public static void main(String[] args) {
        List<String> boxList = new ArrayList<>();
        /*
        t2 13 121 98
r1 box ape bit
b4 xi me nu
br8 eat nim did
w1 has uni gry
f3 52 54 31
         */
        boxList.add("a1 pz ft gj ab");
        boxList.add("aa pz ft gj ab");
        //boxList.add("b4 xi me nu");
        //boxList.add("br8 eat nim did");
        //boxList.add("w1 has uni gry");
        //boxList.add("f3 52 54 31");
        sortBoxes(boxList);

    }
    public static List<String> sortBoxes(List<String> boxList) {
        // Write your code here
        // lowest version == space delimieted lower case english strings
        // higher version = space delimieted positive integer
        // old should come first
        Collections.sort(boxList,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                int splitIndForS2 = s2.indexOf(" ");
                int splitIndForS1 = s1.indexOf(" ");
                boolean isDigitFoundForS2 = isDigitPresent(s2,splitIndForS2);
                boolean isDigitFoundForS1 = isDigitPresent(s1,splitIndForS1);
                if((!isDigitFoundForS1 && !isDigitFoundForS2)){
                    int cmp =  s1.substring(splitIndForS1+1,s1.length()).compareTo(s2.substring(splitIndForS2+1,s2.length()));
                    if(cmp != 0){
                        return cmp;
                    }else{
                        return s1.substring(0,splitIndForS1+1).compareTo(s2.substring(0,splitIndForS2+1));
                    }
                }else{
                    if(isDigitFoundForS1 && isDigitFoundForS1){

                    }
                    if(isDigitFoundForS1){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        return boxList;

    }
    private static boolean isDigitPresent(String str,int ind){
        for(int i = ind+1;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
