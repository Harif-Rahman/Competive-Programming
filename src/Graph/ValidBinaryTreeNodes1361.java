package Graph;

import java.util.HashSet;
import java.util.Set;
/*
You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.
 */
public class ValidBinaryTreeNodes1361 {
    public static void main(String[] args) {
        int n= 4;
        int[] leftchild = {1,-1,3,-1};
        int[] rightchild = {2,-1,-1,-1};
        validateBinaryTreeNodes(n,leftchild,rightchild);
    }

    /**
     * TC : (O(N + N FOR DFS)
     * SC : O(N + N FOR STACK SPACE)
     *
     * first use the indegree to find out the root
     * after finding the root just foollow the any order traversal then is the node is already visited then it is not binary tree
     * also for mult compoenent graph do the check using visited set
     *
     *
     *
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] dependecy = new int[n];
        for(int i=0;i<n;i++){
            int leftVal = leftChild[i];
            int rightVal = rightChild[i];

            if(leftVal != -1){
                dependecy[leftVal]++;
            }
            if(rightVal != -1){
                dependecy[rightVal]++;
            }
        }
        // find out root node
        int rootNode = -1;
        for(int i=0;i<n;i++){
            if(dependecy[i] == 0){
                rootNode = i;
                break;
            }
        }
        if(rootNode == -1){
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        return isBinaryTree(rootNode,leftChild,rightChild,visited) && visited.size() == n;
    }
    // check whehter it is a tree followed pre order traversal
    private static boolean isBinaryTree(int root,int[] leftChild,int[] rightChild,Set<Integer> set){
        if(root == -1){
            return true;
        }
        if(!set.add(root)){
            return false;
        }
        boolean left = isBinaryTree(leftChild[root],leftChild,rightChild,set);

        boolean right = isBinaryTree(rightChild[root],leftChild,rightChild,set);

        return left && right;
    }
}
