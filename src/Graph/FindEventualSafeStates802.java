package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates802 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        eventualSafeNodes(arr);
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer,Integer> stateMap = new HashMap<>();
        Map<Integer,Boolean> cycleMap = new HashMap<>();

        for(int i=0;i<graph.length;i++){
            cycleMap.put(i,isCycle(graph,i,stateMap,cycleMap));
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(cycleMap.get(i) != null && !cycleMap.get(i)){
                res.add(i);
            }
        }
        return res;

    }
    private static boolean isCycle(int[][] graph,int node,Map<Integer,Integer> stateMap,Map<Integer,Boolean> cycleMap){
        if(cycleMap.get(node) != null){
            return cycleMap.get(node);
        }

        // if the node is already in processing state then its cycle
        if(stateMap.get(node) != null && stateMap.get(node) == 1){
            return true;
        }

        if(stateMap.get(node) != null && stateMap.get(node) == 2){
            return false;
        }
        stateMap.put(node,1); // processing

        for(int adjacent : graph[node]){
            if(isCycle(graph,adjacent,stateMap,cycleMap)){
                return true;
            }
        }
        stateMap.put(node,2);
        return false;
    }
}
