package Graph;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelaytime743 {
    public static void main(String[] args) {
        /**
         * [[1,2,1],[2,1,3]]
         * 2
         * 2
         */
        int[][] times = new int[][]{
                {2,1,1},
                {2,3,1},
                {3,4,1},
        };
        networkDelayTime(times,4,2);
    }

    /**
     *V -VERTICES E -EDGES
     * INTUITION
     * USING PRIORITY QUEUE TO GET THE NODE WITH SHORTEST DISTANCE
     * @param times
     * @param N
     * @param K
     * @return
     */
    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        Map<String,Integer> weightMap = new HashMap<>();
        for(int[] time : times){
            if(!adjacentMap.containsKey(time[0])){
                adjacentMap.put(time[0],new ArrayList<>());
            }
            adjacentMap.get(time[0]).add(time[1]);
            weightMap.put(time[0] + "->" + time[1],time[2]);
        }
        // key will be node value will be distance
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1,p2) -> p1.getValue() - p2.getValue());

        pq.add(new Pair<>(K,0));

        int[] distance = new int[N+1]; // shortest distance from source
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[K] = 0; // from source to source shortest distance is zero

        while (!pq.isEmpty()){
            Pair<Integer,Integer> poppedNode = pq.remove();
            int currNode = poppedNode.getKey();
            int currDistance = poppedNode.getValue();

            if(adjacentMap.get(currNode) != null){
                for(int i=0;i<adjacentMap.get(currNode).size();i++){
                    Integer adjacentNode = adjacentMap.get(currNode).get(i);
                    int weight = weightMap.get(currNode +"->"+adjacentNode);
                    // if from the current distance to neighbor node distance is shorter than the already stored distance then update with minimum
                    int distanceToReachSource = currDistance + weight;
                    if(distanceToReachSource < distance[adjacentNode]){
                        // if the current path is minimum then add to min heap
                        pq.add(new Pair<>(adjacentNode,distanceToReachSource));
                        distance[adjacentNode] = distanceToReachSource;
                    }
                }
            }
        }
        int minTimeToReachAllNodes = 0;
        for(int i=1;i<=N;i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            minTimeToReachAllNodes = Math.max(minTimeToReachAllNodes,distance[i]);
        }
        return minTimeToReachAllNodes;
    }
}
