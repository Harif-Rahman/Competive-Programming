package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CousrSchedule207 {
    public static void main(String[] args) {
        canFinish(2,new int[][]{{0,1}});
    }

    /**
     * WORKING
     * TC : O(V + E)
     * SC : O(V + E)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }

        Map<Integer, List<Integer>> depMap = new HashMap<>();

        int[] dependencies = new int[numCourses];


        for(int[] pre : prerequisites){
            if(!depMap.containsKey(pre[1])){
                depMap.put(pre[1],new ArrayList<>());
            }
            dependencies[pre[0]]++;
            depMap.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<dependencies.length;i++){
            if(dependencies[i] == 0){
                queue.add(i);
                numCourses--;
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Integer course = queue.remove();
                if(depMap.get(course) != null){
                    for(int dep : depMap.get(course)){
                        dependencies[dep]--;
                        if(dependencies[dep] == 0){
                            numCourses--;
                            queue.add(dep);
                        }
                    }
                }
            }
        }
        return numCourses == 0;

    }
}
