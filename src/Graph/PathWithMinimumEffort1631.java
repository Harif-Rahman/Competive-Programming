package Graph;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort1631 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(minimumEffortPath(arr));
    }

    /**
     * using dijikstras algorithm single source shortest path algorithm
     * tc : O(E LOG V)
     * sc
     * @param heights
     * @return
     */
    public static int minimumEffortPath(int[][] heights) {
        int[][] distance = new int[heights.length][heights[0].length];
        for(int i=0;i<distance.length;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1, p2) ->
                distance[p1.getKey()][p1.getValue()] - distance[p2.getKey()][p2.getValue()]);

        pq.add(new Pair<Integer,Integer>(0,0));
        int[][] dirs = {
                {1,0},
                {0,1},
                {-1,0},
                {0,-1}
        };

        while(!pq.isEmpty()){
            Pair<Integer,Integer> popped = pq.remove();
            int row = popped.getKey();
            int col = popped.getValue();
            int distanceFromCurrentVistingNodeToSource = distance[row][col];
            for(int[] dir : dirs){
                int nr = dir[0] + row;
                int nc = dir[1] + col;
                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length){
                   int distanceFromNeighbourToSourceViaCurrentNode = Math.max(distanceFromCurrentVistingNodeToSource ,
                           Math.abs(heights[row][col]-heights[nr][nc]));

                   if(distanceFromNeighbourToSourceViaCurrentNode < distance[nr][nc]){
                       distance[nr][nc] = distanceFromNeighbourToSourceViaCurrentNode;
                       pq.add(new Pair<>(nr,nc));
                   }
                }
            }
        }
        return distance[heights.length-1][heights[0].length-1];
    }
}
