package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
/*
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.
 */
public class canVisitAllRooms841 {
    /**
     * WORKING
     * VISUALIZE IT AS A GRAPH
     * TC : O(TOTAL NO OF ROOMS)
     * SC : O(TOTAL NO OF ROOMS)
     * @param rooms
     * @return
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int totalNoOfRoomsNotVisited = N-1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int popped = queue.remove();
                if(rooms.get(popped) != null){
                    for(int adjacent : rooms.get(popped)){
                        if(!visited[adjacent]){
                            queue.add(adjacent);
                            visited[adjacent] = true;
                            totalNoOfRoomsNotVisited--;
                        }
                    }
                }
            }
        }
        return totalNoOfRoomsNotVisited == 0;
    }
}
