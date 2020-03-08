import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class KeysAndRooms841 {
    public static void main(String[] args) {
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(1,3));
        ls.add(Arrays.asList(3,0,1));
        ls.add(Arrays.asList(2));
        ls.add(Arrays.asList(0));
        System.out.println(canVisitAllRooms(ls));
    }
    private static boolean canVisitAllRooms(List<List<Integer>> rooms){
        Set<Integer> hs = new HashSet<>();
        hs.add(0);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        while (!st.isEmpty()){
            int key = st.pop();
                for(int i : rooms.get(key)){
                    if(!hs.contains(i)){
                        st.push(i);
                        hs.add(i);
                    }
                }
        }
        return hs.size() == rooms.size();

    }
    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>(); seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }

}

/*
stack ---[0]
popping 0
stack ---[1, 3]
popping 1
stack ---[3]
popping 3
false
st 0  hs 0
st 3 1   hs 1 3
st 0 3     hs 0 3 1
st 3
st         hs 0 3 1
 */