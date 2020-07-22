import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTravellingSalesPath {
    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {
        static int minPath = Integer.MAX_VALUE;
        static int getCheapestCost(Node rootNode) {
            // your code goes here
            helper(rootNode,0);
            return minPath;
        }
        private static void helper(Node root,int cost){
            // check if it is leaf node
            if(root.children == null){
                minPath = Math.min(cost,minPath);
                return;
            }
            for(Node child : root.children){
                helper(child,child.cost+cost);
            }
        }



    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);
        root.children = new Node[3];
        root.children[0] = new Node(5);
        root.children[1] = new Node(3);
        root.children[2] = new Node(6);
        root.children[0].children = new Node[1];
        root.children[0].children[0] = new Node(4);
        root.children[1].children = new Node[2];
        root.children[1].children[0] = new Node(2);
        root.children[1].children[1] = new Node(0);
        root.children[1].children[1].children = new Node[1];
        root.children[1].children[1].children[0] = new Node(10);
        root.children[2].children = new Node[2];
        root.children[2].children[0]  = new Node(1);
        root.children[2].children[1]  = new Node(5);
        root.children[1].children[0].children = new Node[1];
        root.children[1].children[0].children[0] =  new Node(1);
        System.out.println(SalesPath.getCheapestCost(root));
    }

}
