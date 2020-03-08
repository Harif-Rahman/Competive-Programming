public class SmallestLetterGreaterThanTarget744 {
    public static void main(String[] args) {
        char[] letters = {'a','d','g','k','o'};
        System.out.println(nextGreatestLetter1(letters, 'h'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int res = bS(letters,0,letters.length-1,target);
        return letters[res] <= target ? letters[(res + 1) % letters.length] : letters[res];
    }
    private static int bS(char[] letters,int low,int high,char target){
        if(low < high){
            int mid = low+ (high-low)/2;
            if(letters[mid] == target){
                return mid+1;
            }
            if(letters[mid] < target){
                return bS(letters,mid+1,high,target);
            }
            return bS(letters,low,mid,target);
        }
        return high;
    }
    public static char nextGreatestLetter1(char[] letters, char target) {
        int i = 0;
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return letters[(start)%letters.length];
    }
}
