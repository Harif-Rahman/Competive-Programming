package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock752 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        openLock(deadends,target);
    }
    /*

                    0000
                    / \

     1000   9000   0100 0900 0010 0090  0001 0009


     */
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s : deadends) dead.add(s);
        if (dead.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;
        Set<String> v = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        for (int d = 1; !q.isEmpty(); d++) {
            for (int n = q.size(); n > 0; n--) {
                String cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    for (int dif = 1; dif <= 9; dif += 8) {
                        char[] ca = cur.toCharArray();
                        ca[i] = (char)((ca[i] - '0' + dif) % 10 + '0');
                        String s = new String(ca);
                        if (target.equals(s)) return d;
                        if (!dead.contains(s) && !v.contains(s)) q.add(s);
                        v.add(s);
                    }
                }
            }
        }
        return -1;
    }
}
