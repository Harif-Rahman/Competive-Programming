public class LongPressedName925 {
    public static void main(String[] args) {


        System.out.println(isLongPressedName("harrif", "hhaariif"));
    }
    public static boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(i < name.length() && j < typed.length()){
            while(j < typed.length() && name.charAt(i) == typed.charAt(j)){
                j++;
            }
            while(i+1 < name.length() && name.charAt(i) == name.charAt(i+1)){
                i++;
            }
            i++;
            if(j < typed.length() && name.charAt(i) != typed.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
