package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class isCyclePresent {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2}, // to finish course 1 u need to finish course 2
                {2,3},
                {1,3},
                {3,1},
                {3,4},
                {4,6},
                {1,7},
                {2,7}
        };
        Map<Integer, List<Integer>> depMap = new HashMap<>();
        int[] depArr = new int[8];
        for(int[] ar : arr){
            int j = ar[1];
            int i = ar[0];
            depMap.putIfAbsent(j,new ArrayList<>());
            depMap.get(j).add(i);
            depArr[i]++;
        }
        int taskWithNodepedency = -1;

        for(int i=0;i<depArr.length; i++){
            if(depArr[i] == 0){
                taskWithNodepedency = i;
                break;
            }
        }
        System.out.println(isCycle(taskWithNodepedency, depMap, new HashMap<>()));
    }
    private static boolean isCycle(int pos,Map<Integer, List<Integer>> depMap,Map<Integer,Integer> stateMap){
        if(stateMap.containsKey(pos)){
            if(stateMap.get(pos) == 2){
                return false;
            }
            if(stateMap.get(pos) == 1){
                // already in processing state then its a cycle
                return true;
            }
        }
        stateMap.put(pos,1); // processing state
        if(depMap.get(pos) != null){
            for(int i : depMap.get(pos)){
                boolean isCycle = isCycle(i,depMap,stateMap);
                if(isCycle){
                    return true;
                }
            }
        }
        stateMap.put(pos,2); // completed state
        return false;
    }
    Map<Integer,Integer> state = new HashMap<>();
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(List<Integer> nodes : B){
            if(map.get(nodes.get(0)) == null){
                map.put(nodes.get(0),new ArrayList<Integer>());
            }
            map.get(nodes.get(0)).add(nodes.get(1));
        }
        for(Integer node : map.keySet()){
            if(state.get(node) == null){
                if(isCycle(map,node)){
                    return 1;
                }

            }
        }
        return 0;
    }
    /*
    null - blank
    1 - partial
    2 - complated
    */
    private boolean isCycle(Map<Integer,List<Integer>> map,Integer node){
        if(state.get(node) != null && state.get(node) == 1){
            return true; // cycle
        }
        if(state.get(node) != null && state.get(node) == 2){
            return false; // already visited
        }
        state.put(node,1);
        for(Integer adjacent : map.get(node)){
            if(isCycle(map,adjacent)){
                return true;
            }
        }
        state.put(node,2);
        return false;
    }
}
