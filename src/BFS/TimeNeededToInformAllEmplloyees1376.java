package BFS;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToInformAllEmplloyees1376 {
    public static void main(String[] args) {
        /*
15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
         */
        int n = 15;
        int headId = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(numOfMinutesDFS(n, headId, manager, informTime));
    }

    /**
     * BFS
     * ACCEPTED WITH TC : O(N - TOTNODES)
     * SC : O(N- TOTNODES)
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */
    public static int numOfMinutesBFS(int n, int headID, int[] manager, int[] informTime) {
        //to store all the subordinates in array
        ArrayList<Integer>[] subOrdinatesList = new ArrayList[n];

        for(int i=0;i<n;i++){
            if(manager[i] != -1){
                if(subOrdinatesList[manager[i]] == null){
                    subOrdinatesList[manager[i]] = new ArrayList<>();
                }
                subOrdinatesList[manager[i]].add(i);
            }
        }
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer,Integer>(headID,informTime[headID]));
        int totTime = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> currPair = queue.remove();
                int currHead = currPair.getKey();
                int waitTime = currPair.getValue();
                if(subOrdinatesList[currHead] != null){
                    for(int subordinate : subOrdinatesList[currHead]){
                        queue.add(new Pair<Integer,Integer>(subordinate,waitTime+informTime[subordinate]));
                    }
                }else{
                    // take the maximum time
                    totTime = Math.max(totTime,waitTime);
                }
            }
        }
        return totTime;
    }

    /**
     * DFS
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */
    public static int numOfMinutesDFS(int n, int headID, int[] manager, int[] informTime) {
        //to store all the subordinates in array
        ArrayList<Integer>[] subOrdinatesList = new ArrayList[n];

        for(int i=0;i<n;i++){
            if(manager[i] != -1){
                if(subOrdinatesList[manager[i]] == null){
                    subOrdinatesList[manager[i]] = new ArrayList<>();
                }
                subOrdinatesList[manager[i]].add(i);
            }
        }
        dfs(headID,informTime,subOrdinatesList,informTime[headID]);
        return maxTime;
    }
    private static int maxTime = 0;
    private static void dfs(int currHead,int[] informTime,ArrayList<Integer>[] subordinateMapping,int time){
        if(subordinateMapping[currHead] == null){
            maxTime = Math.max(maxTime,time);
            return;
        }
        for(int subordinate : subordinateMapping[currHead]){
            dfs(subordinate,informTime,subordinateMapping,informTime[subordinate]+time);
        }
    }

}
