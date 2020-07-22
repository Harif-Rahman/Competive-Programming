package Pramp;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {
    public static void main(String[] args) {

    }
    static Map<String,String> resMap = new HashMap<>();
    public static Map<String,String>  flattenDict(Map<String,Object> map,String str,String currKey){

        if(map.get(currKey) instanceof String){
            resMap.put(str+currKey,(String)map.get(currKey));
        }else{
            Map<String,Object> temp = (Map<String, Object>) map.getOrDefault(currKey,map);
            for(String key : temp.keySet()){
                flattenDict(map,currKey+".",key);
            }
        }
        return resMap;
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
