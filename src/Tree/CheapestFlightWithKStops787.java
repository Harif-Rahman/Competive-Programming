package Tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops787 {
    /*
    4
[[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
0
3
1
     */
    public static void main(String[] args) {
        int[][] arr = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        findCheapestPriceBFS(4,arr,0,3, 1);
    }

    /**
     * WORKIING
     *
     * USING DIJISTRAS ALGO
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public static int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K) {
        Map<String,Integer> weightMap = new HashMap<>();
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

        for(int[] flight : flights){
            int s = flight[0];
            int d = flight[1];
            int cost = flight[2];
            adjacentMap.putIfAbsent(s,new ArrayList<>());
            adjacentMap.get(s).add(d);
            weightMap.put(s + "->" + d,cost);
        }

        PriorityQueue<City> pq = new PriorityQueue<City>((c1, c2) -> c1.cost - c2.cost);

        pq.add(new City(0,src,K));

        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0;i<size;i++){
                City city  = pq.remove();
                int stops = city.stops;
                int cost = city.cost;
                int cit = city.city;

                if(cit == dst){
                    return cost;
                }
                if(stops == -1){
                    continue; // we should not add other nodes.
                }
                if(adjacentMap.get(cit) != null){
                    for(int adj : adjacentMap.get(cit)){
                        int weight = weightMap.get(cit + "->" + adj);
                        int dist =  cost + weight;
                        pq.add(new City(dist,adj,stops-1));
                    }
                }
            }
        }
        return -1;

    }
    private static class City{
        int cost;
        int city;
        int stops;

        public City(int cost, int city, int stops) {
            this.cost = cost;
            this.city = city;
            this.stops = stops;
        }
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
