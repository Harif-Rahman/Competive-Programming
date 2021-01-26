package Graph;
/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */
public class NumberOfProvinces547 {
    /**
     * undirected graph
     * no need to worry about adjacent list
     * pick a node and go
     * tc : o(total number of cities)
     * sc : o(total number of cities) for visited array and stack space
     *
     * intution same like no of island but here will pick one node and will pick another node if they are connected
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0){
            return 0;
        }
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected,int currNode,boolean[] visited){
        if(visited[currNode]){
            return;
        }
        visited[currNode] = true;
        for(int i = 0;i<isConnected.length;i++){
            // if current node and pick node is not same
            if(i != currNode && isConnected[i][currNode] == 1){
                dfs(isConnected,i,visited);
            }
        }
    }
}
