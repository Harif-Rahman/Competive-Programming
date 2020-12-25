package Graph;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


Test case format:

For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.

Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph133 {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node n1 = new Node(2);
        node.neighbors = Arrays.asList(n1);
        n1.neighbors = Arrays.asList(node);
        cloneGraph(node);
    }
    public static Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Node clone = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node,Node> map = new HashMap<>();
        map.put(node,clone);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node originalNode = queue.remove(); //original
                for(Node neighbour : originalNode.neighbors){
                    Node clonedNode = new Node(neighbour.val);
                    if(!map.containsKey(neighbour)) {
                        queue.add(neighbour);
                        map.put(neighbour, clonedNode);
                    }
                    map.get(originalNode).neighbors.add(clonedNode);
                }
            }
        }
        return map.get(node);
    }
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
