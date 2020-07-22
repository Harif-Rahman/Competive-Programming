package Tree;

import java.util.HashMap;
import java.util.Map;

public class CheapestFlightWithKStops787 {
    public static void main(String[] args) {
        int[][] arr = {{0,1,100},{1,2,100},{0,2,500}};
        findCheapestPrice(3,arr,0,2, 0);
    }
    static int minCost = Integer.MAX_VALUE;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();

        for(int[] flight : flights){
            Map<Integer,Integer> destMap = map.get(flight[0]);
            if(destMap == null){
                destMap = new HashMap<>(n);
            }
            destMap.put(flight[1],flight[2]);
            map.put(flight[0],destMap);
        }
        dfs(map,K,n,src,dst,0);
        return minCost;
    }
    private static void dfs(Map<Integer,Map<Integer,Integer>> map,int k,int ind,int n,int dest,int cost){

        if(ind >= n){
            return;
        }
        if(ind == dest){
            minCost = Math.min(minCost,cost);
            return;
        }

        if(k < 0){
            return;
        }
        if(map.get(ind) != null){
            for(Integer i : map.get(ind).keySet()){
                System.out.println("---->"+i);
                dfs(map,k-1,i,n,dest,cost+map.get(ind).get(i));
            }
        }
    }
}
