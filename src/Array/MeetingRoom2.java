package Array;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Have you met this question in a real interview?
Example
Example1

Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)
Example2

Input: intervals = [(2,7)]
Output: 1
Explanation:
Only need one meeting room
 */
public class MeetingRoom2 {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));
        minMeetingRoom(intervals);

    }

    /**
     * WORKING
     *
     * TC : N - intervals length   >  N * logN  + N LOGN
     * SC : N FOR STORING IN PQ
     * @param intervals
     * @return
     */
    private static int minMeetingRoom(List<Interval> intervals){
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<>((i1,i2) -> i1.end - i2.end);
        pq.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            Interval earliest = pq.remove();
            // non overlap
            if(earliest.end <= curr.start){
                earliest.end = Math.max(earliest.end,curr.end);
            }else{
                pq.add(curr);
            }
            pq.add(earliest);
        }
        return pq.size();
    }
    static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
