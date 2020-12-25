package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    /*
    Given a two dimensional array of string like => completed
  <”luke”, “shaw”>
  <”wayne”, “rooney”>
  <”rooney”, “ronaldo”>
  <”shaw”, “rooney”>
  Where the first string is “child”, second string is “Father”.
  And given “ronaldo” we have to find his no of grandchildren
  and children based on given level. if level 1 and given parent Here
  “ronaldo” has 1 children. So our output should be 1, similarly if level is 2
  and given parent is "ronaldo" has 2 grandchildren so the output should be 2.

please any one solve this problem in efficient way and share it here.
     */
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"luke","shaw"}, // child,father
                {"wayne","rooney"},
                {"rooney","ronaldo"},
                {"shaw","rooney"},
        };
        Map<String, List<String>> familyMapList = new HashMap<>();

        for(String[] arrStr : arr){
            String father = arrStr[1];
            String child = arrStr[0];
            if(familyMapList.get(father) == null){
                familyMapList.put(father,new ArrayList<>());
            }
            familyMapList.get(father).add(child);
        }
        int levelToFind = 2;
        String parent = "ronaldo";

        System.out.println(findNoOfChildrens(familyMapList, parent, 1, levelToFind));

    }

    /**
     * DFS
     * @param familyMapList
     * @param parent
     * @param currLevel
     * @param level
     * @return
     */
    private static int findNoOfChildrens(Map<String,List<String>> familyMapList,String parent,int currLevel,int level){

        if(familyMapList.get(parent) == null){
            return 0;
        }

        if(currLevel == level){
            return familyMapList.get(parent).size();
        }

        for(String str : familyMapList.get(parent)){
            return findNoOfChildrens(familyMapList,str,currLevel+1,level);
        }
        return 0;
    }

}
