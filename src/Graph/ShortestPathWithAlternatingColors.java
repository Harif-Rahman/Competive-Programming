package Graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        shortestAlternatingPaths(3,new int[][]{{0,1},{1,2}},new int[][]{});
    }

    /**
     * BFS
     *
     * TC : V*E
     *
     * SC :  E
     *
     * WORKING
     * EXPECTED TO HAVE PARALLEL EDGE AND SELF EDGE NORMAL VISITED ARRAY WILL NOT WORK HERE
     *
     *
     * @param n
     * @param red_edges
     * @param blue_edges
     * @return
     */
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        Map<String,Character> colourMap = new HashMap<>();
        for(int[] redEdge : red_edges){
            adjacentMap.computeIfAbsent(redEdge[0], k -> new ArrayList<>());
            adjacentMap.get(redEdge[0]).add(redEdge[1]);
            colourMap.put(redEdge[0] +"->" +redEdge[1] + "->" + "R",'R');
        }
        for(int[] blueEdge : blue_edges){
            adjacentMap.computeIfAbsent(blueEdge[0], k -> new ArrayList<>());
            adjacentMap.get(blueEdge[0]).add(blueEdge[1]);
            colourMap.put(blueEdge[0] +"->" +blueEdge[1] + "->" + "B",'B');
        }
        Queue<Pair<Character,Integer>> queue = new LinkedList<>();
        queue.add(new Pair('-',0));
        int[] distance = new int[n];
        Arrays.fill(distance,-1);
        distance[0] = 0;                                                         //R
        Set<String> set = new HashSet<>(); // visited set path with colotr eg : 1---->2 this path has parallel edge then we should have path as (1>2>R,1>2>B)
                                                                                 //B
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<Character,Integer> pair = queue.remove();
                Character prevColor = pair.getKey();
                Integer node = pair.getValue();
                if(adjacentMap.get(pair.getValue()) != null){
                    for(int adjacent : adjacentMap.get(pair.getValue())){
                        String strWithBlue = node + "->" + adjacent + "->" + "B"; //PATH WITH BLUE COLOUR
                        String strWithRed = node + "->" + adjacent + "->" + "R";//PATH WITH RED COLOUR
                        Character blueColor = colourMap.get(strWithBlue);

                        if(colourMap.containsKey(strWithBlue) && !set.contains(strWithBlue) && prevColor != blueColor){
                            set.add(strWithBlue);
                            queue.add(new Pair<>('B',adjacent));
                            distance[adjacent] = distance[adjacent] == -1 ? level : Math.min(distance[adjacent],level);
                        }
                        Character redColor = colourMap.get(strWithRed);

                        if(colourMap.containsKey(strWithRed) && !set.contains(strWithRed) && prevColor != redColor){
                            set.add(strWithRed);
                            queue.add(new Pair<>('R',adjacent));
                            distance[adjacent] = distance[adjacent] == -1 ? level : Math.min(distance[adjacent],level);
                        }
                    }
                }
            }
            level++;
        }

        return distance;

    }
}
