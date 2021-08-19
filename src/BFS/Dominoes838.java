package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Dominoes838 {
    public static void main(String[] args) {
        String str = "R..L";
        // RR.LL
        // RRRLL
        pushDominoes(str);
    }
    public static String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        boolean[] changed = new boolean[arr.length];

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(c == 'L' || c == 'R'){
                queue.add(i);
            }
        }
        boolean[] visited = new boolean[arr.length];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int pop = queue.remove();
                if(!visited[pop] && arr[pop] == 'L' && pop-1 >= 0){
                    if(arr[pop - 1] == '.'){
                        arr[pop-1] = 'L';
                        changed[pop-1] = true;
                        queue.add(pop-1);
                    }else{
                        if(changed[pop-1]){
                            arr[pop-1] = '.';
                        }
                    }
                }
                if(!visited[pop] && arr[pop] == 'R' && pop+1 <arr.length){
                    if(arr[pop + 1] == '.'){
                        arr[pop+1] = 'R';
                        changed[pop+1] = true;
                        queue.add(pop+1);
                    }else{
                        if(changed[pop+1]){
                            arr[pop+1] = '.';
                        }
                    }
                }
                visited[pop] = true;
            }
        }
        return new String(arr);
    }
}
