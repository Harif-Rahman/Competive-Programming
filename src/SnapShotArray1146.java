import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapShotArray1146 {
    public static void main(String[] args) {
        /**
         ["SnapshotArray","set","snap","set","get"]
         [[3],[0,5],[],[0,6],[0,0]]
         ["SnapshotArray","snap","snap","snap","snap","get","set","set"]
         [[4],[],[],[],[],[1,2],[0,10],[3,18]]
         */
        SnapshotArray snapshotArray = new SnapshotArray(4);

        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.get(1,2);

        snapshotArray.get(0,10);
        snapshotArray.get(3,18);
    }
    static class SnapshotArray {
        TreeMap<Integer,Integer>[] treeMap = null;
        int currSnap = 0;
        public SnapshotArray(int length) {
            treeMap = new TreeMap[length];
            for(int i=0;i<length;i++){
                treeMap[i] = new TreeMap<>();
                treeMap[i].put(0,0);
            }
        }

        public void set(int index, int val) {
            treeMap[currSnap].put(index,val);
        }

        public int snap() {
            return ++currSnap-1;
        }

        public int get(int index, int snap_id) {
            Integer res = treeMap[index].floorKey(snap_id);
            if(res == null){
                return 0;
            }
            return treeMap[index].get(res);
        }
    }


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
}
