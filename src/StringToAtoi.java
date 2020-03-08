public class StringToAtoi {
    public static int myAtoi(String str) {
        str = truncateTrailWhiteSpace(str);
        if(str.length() == 0)
            return 0;
        int i=0;
        if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
            return 0;
        }
        int sign = str.charAt(i) == '-' ? -1 : str.charAt(i) == '+' ? 1 : 0;
        if(sign != 0){
            i++;
        }
        int j=i;
        while(j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9'){
            j++;
        }

        str = str.substring(i,j);
        i=0;
        long res =0;
        while(i < str.length()){
            res+= (str.charAt(i++) - '0');
            if(res > Integer.MAX_VALUE){
                res =  sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
                return (int)res;
            }
            res *= 10;
        }
        return (int)((sign * res)/10);
    }
    private static String truncateTrailWhiteSpace(String str){
        int i=0;
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        return str.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(
                "2147483646"));
    }
    //2147483647
    //21474836460 res

}
