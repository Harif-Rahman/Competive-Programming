import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B'};
        leastInterval(tasks,2);
    }

    /**
     * we are trying to simulate the job
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        Map<Character, Integer> taskToCount = new HashMap<>();
        for (char c : tasks) {
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1); // greater task
        for (char c : taskToCount.keySet()) queue.offer(taskToCount.get(c));

        Map<Integer, Integer> coolDown = new HashMap<>();
        int currTime = 0;
        while (!queue.isEmpty() || !coolDown.isEmpty()) {
            // A B # A B # A
            // 0 1 2 3 4 5 6

            if(coolDown.containsKey(currTime-n-1)){  // we are subtracting idle time from current time to get what is the task we did previoudly
                queue.add(coolDown.remove(currTime-n-1)); // remove will return the value associated with the key
            }
            if(!queue.isEmpty()){
                int left = queue.remove()-1; // remaining task left
                // put if left is more than  0
                if(left > 0){
                    coolDown.put(currTime,left);
                }
            }
            currTime++;
        }
        return currTime;
    }
}
