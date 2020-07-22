package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodeDistanceKInBinaryTree863 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(5);;
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(2);
        TreeNode target = tree.left;
        tree.left.right.left = new TreeNode(7);
        tree.left.right.right    = new TreeNode(4);
        tree.right = new TreeNode(1);;
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(8);
        distanceK(tree,target,2);
    }

    /**
     * completed
     * TC :
     * @param root
     * @param target
     * @param K
     * @return
     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        dfs(null,root,parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        while(K-- > 0 && !queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.remove();
                if(parentMap.get(curr) != null && seen.add(parentMap.get(curr))){
                    queue.add(parentMap.get(curr));
                }
                if(curr.left != null && seen.add(curr.left)){

                    queue.add(curr.left);
                }
                if(curr.right != null && seen.add(curr.right)){
                    queue.add(curr.right);
                }
            }
        }
        List<Integer> ls = new ArrayList<>(queue.size());
        while(!queue.isEmpty()){
            ls.add(queue.remove().val);
        }
        return ls;
    }
    private static void dfs(TreeNode parent,TreeNode curr,Map<TreeNode,TreeNode> map){
        if(curr == null){
            return;
        }
        map.put(curr,parent);
        dfs(curr,curr.left,map);
        dfs(curr,curr.right,map);
    }
  /*  static Map<TreeNode, Integer> map = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private static int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private static void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }*/
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
