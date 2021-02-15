package Pramp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FlattenDictionary {
    public static void main(String[] args) {
        HashMap<String,Object> inputMap = new HashMap<>();
        inputMap.put("Key1","1");
        Map<String,Object> m1 = new HashMap<>();
        m1.put("a","2");
        m1.put("b","3");

        inputMap.put("Key2",m1);
        flattenDictionary(inputMap);

    }
    static Map<String,String> resMap = new HashMap<>();
/*    public static Map<String,String>  flattenDict(Map<String,Object> map,String str,String currKey){

        if(map.get(currKey) instanceof String){
            resMap.put(str+currKey,(String)map.get(currKey));
        }else{

            Map<String,Object> temp = (Map<String, Object>) map.getOrDefault(currKey,map);
            for(String key : temp.keySet()){
                flattenDict(map,currKey+".",key);
            }
        }
        return resMap;
    }*/

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String,String> res = new HashMap<>();
        for(String key : dict.keySet()){
            flatten(dict,res,key,key);
        }
        return res;
    }

    static void flatten(HashMap<String, Object> dict,Map<String,String> res,String key,String concatKey){
        Object val = dict.get(key);
        if(val instanceof String){
            res.put(concatKey,(String)val);
        }else{
            if(dict.get(key) != null){
                HashMap<String,Object> m = (HashMap<String, Object>)dict.get(key);
                for(String lkey : m.keySet()){
                    flatten(m,res,lkey,concatKey+"."+lkey);
                }
            }
        }
    }
    static int findBusiestPeriod(int[][] data) {
        // your code goes here
        int maxNoOfPeopleInMall = 0;
        int currNoOfPeopleInsideMall = 0;
        for(int i=0;i<data.length;i++){
            int[] arr = data[i];
            int people = arr[1];
            boolean entry = arr[2] == 1 ? true : false;

            if(entry){
                currNoOfPeopleInsideMall += people;
            }
            else{
                currNoOfPeopleInsideMall -= people;
            }
            if(i == data.length-1 ||  (data[i][0] < data[i+1][0])){
                maxNoOfPeopleInMall =   Math.max(maxNoOfPeopleInMall,currNoOfPeopleInsideMall);
            }
        }
        return maxNoOfPeopleInMall;
    }
}
