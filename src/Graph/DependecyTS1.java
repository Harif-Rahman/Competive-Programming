package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DependecyTS1 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2}, // to finish course 1 u need to finish course 2
                {2,3},
                {1,3},
                {3,4},
                {4,6},
                {1,7},
                {2,7}
            };
    Map<Integer,List<Integer>> depMap = new HashMap<>();
    int[] depArr = new int[8];
    Set<Integer> set = new HashSet<>();
    for(int[] ar : arr){
        int j = ar[1];
        int i = ar[0];
        depMap.putIfAbsent(j,new ArrayList<>());
        depMap.get(j).add(i);
        depArr[i]++;
        set.add(i);
        set.add(j);
    }
    getOrder(depArr,depMap,set);
    }
    private static List<Integer> getOrder(int[] depArr,Map<Integer,List<Integer>> depMap,Set<Integer> set){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<depArr.length;i++){
            if(depArr[i] == 0){
                if(set.contains(i)){
                    queue.add(i) ;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int taskWithNodependecy = queue.remove();
            res.add(taskWithNodependecy);
            if(depMap.get(taskWithNodependecy) != null){
                for(Integer dep : depMap.get(taskWithNodependecy)){
                    depArr[dep]--;
                    if(depArr[dep] == 0){
                        queue.add(dep);
                    }
                }
            }
        }
        return res;
    }
}
