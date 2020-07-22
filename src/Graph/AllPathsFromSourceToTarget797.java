package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllPathsFromSourceToTarget797 {
    public static void main(String[] args) {
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(1,2));
        ls.add(Arrays.asList(3));
        ls.add(Arrays.asList(3));
        ls.add(Collections.emptyList());
        allPathsSourceTarget(ls);
    }
    static List<List<Integer>> res = new ArrayList<>();

    /**
     * DFS
     * @param ls
     * @return
     */
    public static List<List<Integer>> allPathsSourceTarget(List<List<Integer>> ls) {
        dfs(ls,0,new ArrayList<>());
        return res;
    }
    private static void dfs(List<List<Integer>> graph,int pos,List<Integer> list){
        list.add(pos);
        if(pos == graph.size()-1){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<graph.get(pos).size();i++){
            dfs(graph,graph.get(pos).get(i),list);
            list.remove(list.size()-1);
        }
    }
}
