import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=GSBLe8cKu0s&ab_channel=TusharRoy-CodingMadeSimple
 * https://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/
 */
public class SkyLineProblem218 {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{
            /*    {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}*/

                {0,2,3},
                {2,5,3}
        };
        getSkyline(buildings);
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];

        int index = 0;
        for(int[] building : buildings){
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].setStart(true);
            buildingPoints[index].setX(building[0]);
            buildingPoints[index].setY(building[2]);
            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].setStart(false);
            buildingPoints[index+1].setX(building[1]);
            buildingPoints[index+1].setY(building[2]);

            index += 2;
        }
        Arrays.sort(buildingPoints);
        List<List<Integer>> boundary = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        priorityQueue.add(0);
        for(BuildingPoint buildingPoint : buildingPoints){
            if(buildingPoint.isStart){
                // then push to queue
                if(priorityQueue.peek() < buildingPoint.y){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(buildingPoint.x);
                    ls.add(buildingPoint.y);
                    boundary.add(ls);
                }
                priorityQueue.add(buildingPoint.y);
            }else{
                priorityQueue.remove(buildingPoint.y);
                if(priorityQueue.peek() < buildingPoint.y){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(buildingPoint.x);
                    ls.add(priorityQueue.peek());
                    boundary.add(ls);
                }
            }
        }
        return boundary;
    }
    static class BuildingPoint implements Comparable<BuildingPoint>{
        int x;
        int y;
        boolean isStart;

        BuildingPoint(){
            isStart = false;
            x = 0;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setStart(boolean start) {
            isStart = start;
        }

        public void setY(int y) {
            this.y = y;
        }
/*
if x values are not same then compare x point only
else
then
if both building is the start point
then building with higher height should be picked first
else
if both bulding is the end point
then building with lower height should be picked first
else
if first bulding is end starts with next building start
then pick up the next building height
 */
        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x)
                return Integer.compare(this.x, o.x);

            if (this.isStart && o.isStart) {
                return Integer.compare(o.y, this.y);
            }

            if (!this.isStart && !o.isStart) {
                return Integer.compare(this.y, o.y);
            }

            return this.isStart ? -1 : 1;
        }
    }
}
