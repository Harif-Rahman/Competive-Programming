package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelOrderTraversal102 {


    private List<List<Integer>> gls = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.left = new TreeNode(5);
        tree.right.left.left = new TreeNode(7);
        tree.right.right = new TreeNode(6);
        List<List<Integer>> ls = new ArrayList<>();
        levelOrder(tree);


    }

    private static void lOrder(TreeNode root,List<List<Integer>> ls,int height){
        if(root == null)
            return;
        if(ls.size() == height){
            ls.add(height, Stream.of(root.val).collect(Collectors.toList()));
        }else{
            ls.get(height).add(root.val);
        }
        lOrder(root.left,ls,height+1);
        lOrder(root.right,ls,height+1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
