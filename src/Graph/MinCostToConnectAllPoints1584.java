package Graph;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
/*
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 */
public class MinCostToConnectAllPoints1584 {
    public static void main(String[] args) {
        //[[0,0],[2,2],[3,10],[5,2],[7,0]]
        int[][] arr ={{0,0},{2,2},{3,10},{5,2},{7,0}};
        minCostConnectPoints(arr);

    }
    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int dist1 = getDistance(points,o1.getKey(),o1.getValue());
                int dist2 = getDistance(points,o2.getKey(),o2.getValue());
                return dist1-dist2;
            }
        });
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                pq.add(new Pair<>(i,j));
            }
        }

        int totalVertices = points.length;
        int minCost = 0;
        Set<Integer> set = new HashSet<>();
        int totEdges = 0;


        int[] parent = new int[points.length];
        Arrays.fill(parent,-1);
        int lastparent = -1;
        while (!pq.isEmpty()){
            Pair<Integer,Integer> pair = pq.remove();
            int ind1 = pair.getKey();
            int ind2 = pair.getValue();
            if(isCycle(parent,ind1,ind2)){
                // it could form cycle
                continue;
            }
            minCost += getDistance(points,ind1,ind2);
            totEdges++;

            set.add(ind1);
            set.add(ind2);

            parent[ind1] = lastparent;
            parent[ind2] = ind1;
            lastparent = ind1;

            //SPANNING TREE PROPERTY --> edges should be equal to vertices - 1
            if(totEdges == totalVertices-1){
                break;
            }
        }
        return minCost;
    }
    private static boolean isCycle(int[] parent,int i,int j){
        if(parent[i] == -1 && parent[j] == -1){
            return i==j;
        }
        return isCycle(parent,i == -1 ? -1 : parent[i],j == -1 ? -1 :parent[j]);
    }
    private static int getDistance(int[][] points,int ind1,int ind2){
        int[] p1 = points[ind1];
        int[] p2 = points[ind2];

        int r1 = Math.abs(p2[0]-p1[0]);
        int r2 = Math.abs((p2[1] - p1[1]));
        return  r1 + r2;
    }
}
