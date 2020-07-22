import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters1239 {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("uun","iq","act","ers");
        maxLength(ls);
    }
    public static int maxLength(List<String> ls) {
        int[] arr = new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            int bit = 0;
            String str = ls.get(i);
            for(char c : str.toCharArray()){
                bit |= 1 << c-'a';
            }
            arr[i] = bit;
        }
        int len = 0;
        for(int i=0;i<ls.size();i++){
            for(int j=i+1;j<ls.size();j++){
                if(hasUniqueCharacters(arr[i],arr[j])){
                    len = Math.max(len,ls.get(i).length() + ls.get(j).length());
                }
            }
        }
        return len;

    }
    // 0011 >> ab >> 10
    // 1100 >> cd >> 5
    // 1111 >> 8 + 4 + 2 + 1

    private static boolean hasUniqueCharacters(int bit1,int bit2){
        while(bit1 >0 && bit2 > 0){
            System.out.println("bit1 >>>>>"+Integer.toBinaryString(bit1));
            System.out.println("bit2 >>>>>"+Integer.toBinaryString(bit2));
            if(bit1 % 2  == 1 &&   bit2 % 2 == 1){
                return false;
            }
            bit1 = bit1 >> 1;
            bit2 = bit2 >> 1;
        }
        return true;
    }
}
