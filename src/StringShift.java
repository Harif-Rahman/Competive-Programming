public class StringShift {
    public static void main(String[] args) {
        String s = "yisxjwry";
        int[][] shift = {{1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1}};
        stringShift(s,shift);
    }
    public static String stringShift(String s, int[][] shift) {
        int totLeftShift = 0;
        for(int[] arr : shift){
            totLeftShift += arr[0] == 0 ? -1 : 1;
        }
        totLeftShift = totLeftShift % s.length();
        StringBuilder sb = new StringBuilder();
        if(totLeftShift < 0){
            // left shift
            totLeftShift *= -1;
            sb.append(s.substring(totLeftShift));
            sb.append(s, 0, totLeftShift);
        }else{
            totLeftShift = s.length()- totLeftShift;
            sb.append(s.substring(totLeftShift));
            sb.append(s, 0, totLeftShift);
        }
        return sb.toString();
    }
}
