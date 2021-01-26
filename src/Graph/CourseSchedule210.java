package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule210 {
    /**
     * tc : O(numCourses + )
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] dependecies = new int[numCourses];

        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            dependecies[prerequisite[0]]++;
            if(!adjacentMap.containsKey(prerequisite[1])){
                adjacentMap.put(prerequisite[1],new ArrayList<>());
            }
            adjacentMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();

        int[] order = new int[numCourses];
        int orderInd = 0;

        for(int i=0;i<dependecies.length;i++){
            if(dependecies[i] == 0){
                queue.add(i);
                order[orderInd++] = i;
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int popped = queue.remove();
                if(adjacentMap.get(popped) != null){
                    for(int adjacent : adjacentMap.get(popped)){
                        dependecies[adjacent]--;
                        if(dependecies[adjacent] == 0){
                            queue.add(adjacent);
                            order[orderInd++] = adjacent;
                        }
                    }
                }
            }
        }
        return orderInd == order.length ? order : new int[]{};
    }
}
