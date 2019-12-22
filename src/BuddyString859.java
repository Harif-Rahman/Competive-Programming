public class BuddyString859 {

    public static void main(String[] args) {
        String str1 = "aaaaaaabc";

        System.out.println(buddyStrings("aa","aa"));

    }
    public static boolean buddyStrings(String A, String B) {
        if(A.length() !=B.length() || A.length() == 0 || B.length() == 0)
            return false;
        int i=0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char startChar = A.charAt(0);
        boolean elementsChanged = false;
        while(i<A.length()){
            if(A.charAt(i) != B.charAt(i)){
                sb1.append(A.charAt(i));
                sb2.append(B.charAt(i));
            }
            if(startChar != A.charAt(i))
                elementsChanged = true;
            i++;
        }
        if(sb1.length() == 0 && elementsChanged){
            return false;
        }
        return sb1.reverse().toString().equals(sb2.toString());
    }

}
