import java.util.Arrays;

public class SpiralMatrix59 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateMatrix(4)));
    }
    public static int[][] generateMatrix(int n) {
        ListNode node = new ListNode('R');
        node.next = new ListNode('D');
        node.next.next = new ListNode('L');
        node.next.next.next = new ListNode('U');
        node.next.next.next.next = node;
        int[][] res = new int[n][n];
        Index index = new Index(0,0,node);
        int count = 1;
        while(count <= n*n){
            int i = index.row;
            int j= index.col;
            res[i][j] = count++;
            getDir(res,index,true);
        }
        return res;
    }

    /**
     * delete  this
     * @param res
     * @param index
     * @param flag
     */
    private static void getDir(int[][] res,Index index,boolean flag){
        char c = index.node.data;
        int i = index.row;
        int j = index.col;
        switch(c){
            case 'R':
                if(flag && (j+1 >= res.length ||  res[i][j+1] > 0)){
                    index.node = index.node.next;
                    getDir(res,index,false);
                }else{
                    index.col++;
                }
                break;
            case 'D':
                if(flag && (i+1 >= res.length || res[i+1][j] > 0)){
                    index.node = index.node.next;
                    getDir(res,index,false);
                }else{
                    index.row++;
                }
                break;
            case 'L':
                if(flag && (j-1 < 0 || res[i][j-1] > 0)){
                    index.node = index.node.next;
                    getDir(res,index,false);
                }else{
                    index.col--;
                }
                break;
            case 'U':
                if(flag && (i-1 < 0  || res[i-1][j] > 0)){
                    index.node = index.node.next;
                    getDir(res,index,false);
                }else{
                    index.row--;
                }
                break;
        }
    }
    static class ListNode{
        char data;
        ListNode next;
        ListNode(char data){
            this.data = data;
        }
    }
    static class Index {
        int row;
        int col;
        ListNode node ;
        public Index(int row, int col,ListNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }
}
