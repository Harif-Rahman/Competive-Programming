package Graph;
/*

In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v
 */
public class RedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        UnionFind uf = new UnionFind(parent);
        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            if(!uf.union(n1,n2)){
                return new int[]{n1,n2};
            }
        }
        return new int[]{};
    }
    class UnionFind{
        int[] parent;
        UnionFind(int[] parent){
            this.parent = parent;
            for(int i=1;i<parent.length;i++){
                parent[i] = i;
            }
        }
        private boolean union(int A,int B){
            int findA = find(A);
            int findB = find(B);

            if(findA == findB){
                return false;
            }
            parent[findA] = findB; // union
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
