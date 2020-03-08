package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
     //bfs   averageOfLevels(tree);
      /*
      DFS
          helper(tree,ls,0);
          List<DataHolder> ls = new ArrayList<>();
          List<Double> res = new ArrayList<>();
          for(DataHolder dataHolder : ls){
            res.add(dataHolder.sum/dataHolder.count);
        }
       */


    }

    /**
     * BFS ACCEPTED
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ls = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum=0.0;
            for(int i=0;i<size;i++){
                TreeNode tree = queue.poll();
                if(tree.left != null){
                    queue.add(tree.left);
                }
                if(tree.right != null){
                    queue.add(tree.right);
                }
                sum+=tree.val;
            }
            Double res = (sum/size);
            ls.add(res);
        }
        return ls;
    }

    /**
     * DFS
     * @param root
     * @param ls
     * @param height
     * @return
     */
    public static void helper(TreeNode root,List<DataHolder> ls,int height){
        if(root == null)
            return ;
        if(height == ls.size()){
            DataHolder dataHolder = new DataHolder(1,root.val);
            ls.add(dataHolder);
        }else{
            ls.get(height).sum+=root.val;
            ls.get(height).count++;
        }
        helper(root.left,ls,height+1);
        helper(root.right,ls,height+1);
    }

    static class DataHolder{
        private int count;
        private double sum;

        public DataHolder(int count, double sum) {
            this.count = count;
            this.sum = sum;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }
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
