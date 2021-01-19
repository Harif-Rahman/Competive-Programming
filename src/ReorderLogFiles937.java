import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorderLogFiles937 {
    public static void main(String[] args) {
        String[] arr = {"g1 act car","a2 act car"};

        reorderLogFiles(arr);
        System.out.println(arr);
    }

    /**
     * tc : o(n) + o(m*nlogn) m is the maximum string length
     * sc : o(n)
     * @param logs
     */
    public static void reorderLogFiles(String[] logs) {
        Map<String,ReoderLogData> map = new HashMap<>();
        for(int i=0;i<logs.length;i++){
            String str = logs[i];
            int startIndex = str.indexOf(" ");
            char c = str.charAt(startIndex+1);
            boolean letterLog =c >= 'a' && c <= 'z' ;
            map.put(str,new ReoderLogData(letterLog,startIndex+1,-1));
        }

        Arrays.sort(logs, (o1, o2) -> {
            ReoderLogData r1 = map.get(o1);
            ReoderLogData r2 = map.get(o2);

            if(r1.isLetterLog && r2.isLetterLog){
                // both are letter log
                // do lexicographical sorting
                int cmp = o1.substring(r1.startDigit).compareTo(o2.substring(r2.startDigit));
                if(cmp != 0){
                    return cmp;
                }
                return o1.substring(0,r1.startDigit).compareTo(o1.substring(0,r2.startDigit));
            }else{
                if(!r1.isLetterLog && !r2.isLetterLog){
                    // both are digit logs
                    return r1.index - r2.index; // sort by original position
                }else{
                    if(r1.isLetterLog){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
        });
    }
    private static class ReoderLogData{
        boolean isLetterLog;
        int startDigit;
        int index;

        public ReoderLogData(boolean isLetterLog, int startDigit, int index) {
            this.isLetterLog = isLetterLog;
            this.startDigit = startDigit;
            this.index = index;
        }
    }
}
