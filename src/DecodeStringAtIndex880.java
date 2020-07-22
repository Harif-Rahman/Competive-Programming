public class DecodeStringAtIndex880 {
    public static void main(String[] args) {
        String str = "leet2code3";
        /*
        * leetleet
        * leetleetcodeleetleetcodeleetleetcode
        * leetleetcodeleetleetcodeleetleetcode
        * leetleetcodeleetleetcodeleetleetcodeleetleetcode
        * leetleetcodeleetleetcodeleetleetcode
        *
        *
        * */
        int k = 50;
        decodeAtIndex(str,k);
    }
    public static String decodeAtIndex(String S, int k) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i < S.length() && sb.length() < k){
            if(S.charAt(i) >= '0' && S.charAt(i) <= '9'){
                int times = S.charAt(i) - '0';
                String str = sb.toString();
                while(times-- > 1 && sb.length() < k){
                    sb.append(str);
                }
            }else{
                sb.append(S.charAt(i));
            }
            i++;
        }
        return ""+sb.charAt(k-1);
    }
}
