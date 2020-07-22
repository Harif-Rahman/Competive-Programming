public class MinNoStepsToMakeAnagram1347 {
    public static void main(String[] args) {
        String s = "aba";
        minSteps(s,"bba");
    }
    public static int minSteps(String s, String t) {
        int[] res = new int[26];
        for(int i=0;i<s.length();i++){
            res[s.charAt(i)-'a']++;
            res[t.charAt(i)-'a']--;
        }
        int count =0;
        for(int i=0;i<26;i++){
            count+= Math.abs(res[i]);
        }
        return count/2;

    }
}
