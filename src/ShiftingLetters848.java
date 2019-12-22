public class ShiftingLetters848 {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("ruu",new int[]{26,9,17}));
    }
    public static String shiftingLetters(String s, int[] shifts) {
        String str = s.substring(0,shifts.length);
        String newString = new String();
        String str1 = s.substring(shifts.length,s.length());
        int sum=0;
        for(int i=shifts.length-1;i>=0;i--){
            sum += shifts[i];
            char c = (char)(str.charAt(i) + (sum % (int)'z'));
            newString =  c + newString;
        }
        return newString+str1;
    }
    // a- 97 z -122
    //117 + 17 134
}
