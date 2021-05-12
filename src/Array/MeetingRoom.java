package Array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] arr = {
                {0,4},
                {5,8},
                {8,10},
                {11,12}

        };
        System.out.println(possibleToAttendAllMeetings(arr));
    }
    private static boolean possibleToAttendAllMeetings(int[][] bookedslots){
        Arrays.sort(bookedslots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] ;
            }
        });
        int end = 0;
        for(int [] slot : bookedslots){
            int startTime = slot[0];
            int endTime = slot[1];
            if(startTime < end){ /// start time should be greater than end
                return false;
            }
            end = endTime;
        }
        return true;
    }
}
