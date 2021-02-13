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
        int max = Integer.MIN_VALUE;
        System.out.println(myAtoi1(
                "2147483646"));
    }
    public static int myAtoi1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0;

        for(;left<s.length();left++){
            if(s.charAt(left) == ' '){
                continue;
            }
            break;
        }
        boolean isNegative = false;
        if(left < s.length()){
            if(s.charAt(left) == '-'){
                isNegative = true;
                left++;
            }else{
                if(s.charAt(left) == '+'){
                    left++;
                }
            }
        }
        for(;left<s.length();left++){
            if(s.charAt(left) == '0'){
                continue;
            }
            break;
        }
        //s.charAt(left) == '0'


        Integer res = 0;

        if(left < s.length() && !(s.charAt(left) >= '0' && s.charAt(left) <='9')){
            return res;
        }

        for(;left<s.length() && Character.isDigit(s.charAt(left));left++){
            res += Character.getNumericValue(s.charAt(left));
            if(isOverflow(res,10)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res *10;
        }
        res /=10;

        return isNegative ? -1 * res : res;
    }
    public static boolean isOverflow( int a, int b)
    {
        // Check if either of them is zero
        if (a == 0 || b == 0)
            return false;
        int result = a * b;
        if (a == result / b)
            return false;
        else
            return true;
    }
    /*
    1) i need to trim the leading white spaces
    2) i need to trim the leading zeros
    3) find the sign of integer
    4) ignore the alpha characters
    5) if the string goes more than maximum or minimum then return int max and min
    6) if the string starts with alphabest other than digit then return 0;
    */
    //2147483647
    //21474836460 res

}
