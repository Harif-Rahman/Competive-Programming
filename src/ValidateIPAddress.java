public class ValidateIPAddress {
    public static void main(String[] args) {

    }
    static boolean validateIP(String ip) {
        // your code goes here
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String str : split) {
            //check it is a number
            int res = -1;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    res += (c - 48);
                    res *= 10;
                } else {
                    return false;
                }
            }
            res /= 10;
            if (!(res >= 0 && res <= 255)) {
                return false;
            }
        }
        return true;
    }
}
