public class ZigZagConversion6 {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        convert(str,4);
    }
    /*
    P      A    H   N
    A   P  L  S I I G
    Y      I    R
     */
    /*
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
     */
    public static String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
        String re="";
        for(int i=0;i<sb.length;i++){
            re+=sb[i];
        }
        return re.toString();
    }
}
