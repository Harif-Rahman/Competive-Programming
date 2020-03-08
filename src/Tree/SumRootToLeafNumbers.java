package Tree;

import java.util.Stack;

class SumnodeToLeafNumbers {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(1);
        tree.right = new TreeNode(0);
        System.out.println(sumNumbers(tree));
    }

    /**
     * BFS ACCEPTED
     * @param node
     * @return
     */
    public static int sumNumbers(TreeNode node) {
        if(node ==  null)
            return 0;
        Stack<DataHolder> st = new Stack<>();
        DataHolder dh = new DataHolder(node, node.val);
        st.push(dh);
        int sum = 0;
        while (!st.isEmpty()) {
            int size = st.size();
            for (int i = 0; i < size; i++) {
                DataHolder datah = st.pop();
                if (datah.node.left == null && datah.node.right == null) {
                    sum += datah.sum;
                }
                if (datah.node.left != null) {
                    st.push(new DataHolder(datah.node.left,datah.sum * 10 + datah.node.left.val));
                }
                if (datah.node.right != null) {
                    st.push(new DataHolder(datah.node.right,datah.sum * 10 + datah.node.right.val));
                }
            }
        }
        return sum;
    }
    static class DataHolder{
        private int sum;
        TreeNode node;
        DataHolder(TreeNode node,int sum){
            this.node = node;
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
