package Graph;
/*
Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them



Example Input
Input 1:

 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:

 A = 3
 B = [  [1. 2]
        [1, 3]
     ]
 */
public class CycleInUndirectedGraph {
    public int solve(int A, int[][] B) {
        int[] parent = new int[A+1];

        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }
        UnionFind uf = new UnionFind();
        for(int[] g : B){
            int n1 = g[0];
            int n2 = g[1];
            int findA = uf.find(parent,n1);//2
            int findB = uf.find(parent,n2);//3
            if(findA != findB){
                uf.union(parent,findA,findB);
            }else{
                return 1;
            }
        }
        return 0;
    }
    class UnionFind{

        private void union(int[] parent,int A,int B){
            parent[A] = B;
        }
        private int find(int[] parent,int node){
            if(parent[node] == node){
                return node;
            }
            return find(parent,parent[node]);
        }
    }
}
