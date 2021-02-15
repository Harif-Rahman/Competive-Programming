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
        //              i     j
        minCostConnectPoints(arr);

    }

    /**
     * kruskal algorithm
     * WORKING
     * N = POINTS LENTH
     * TC : FOR POPULATING PRIORITY QUEUE N * N* LOGN -> N^2 LOGN   + N*LOGN
     *
     * @param points
     * @return
     */
    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1,p2) -> getDistance(points,p1) - getDistance(points,p2));
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                pq.add(new Pair<>(i,j));
            }
        }
        int[] parent = new int[points.length];
        UnionFind unionFind = new UnionFind(parent);
        Set<String> set = new HashSet<>();
        int totCost = 0;
        int totalEdges = points.length-1;
        while(!pq.isEmpty() && totalEdges > 0){ // for MST TOTAL EDGES SHOULD BE TOTAL NODES -1
            Pair<Integer,Integer> pair = pq.remove();
            int ind1 = pair.getKey();
            int ind2 = pair.getValue();
            String str1 = ind1 + "->" + ind2;
            String str2 = ind2 + "->" + ind1;

            if(set.add(str1) && set.add(str2) && unionFind.union(ind1,ind2)){
                totCost += getDistance(points,pair);
                totalEdges--;
            }
        }
        return totCost;
    }
    private static int getDistance(int[][] points,Pair<Integer,Integer> pair){
        int[] p1 = points[pair.getKey()];
        int[] p2 = points[pair.getValue()];
        return Math.abs(p2[0]-p1[0]) + Math.abs(p2[1]-p1[1]);
    }
    static class UnionFind{
        int[] parent ;
        UnionFind(int[] parent){
            this.parent = parent;
            for(int i=0;i<parent.length;i++){
                parent[i] = i;
            }
        }

        private boolean union(int A,int B){
            int findA = find(A);
            int findB = find(B);
            if(findA == findB){
                return false;
            }
            parent[findA] = findB;
            return true;
        }
        private int find(int node){
            if(parent[node] == node){
                return node;
            }
            return find(parent[node]);
        }
    }
}
