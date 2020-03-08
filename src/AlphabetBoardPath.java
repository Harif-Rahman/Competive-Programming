public class AlphabetBoardPath {
    public static void main(String[] args) {
        String target = "zdz";
        int startRow =0;
        int startCol = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : target.toCharArray()){
            int row = (c - 'a')/5;
            int col = (c - 'a') % 5;
            /*
            PREFERENCE TO HANDLE Z CASE
            U R L D
             */
            while (startRow > row){
                sb.append("U");
                startRow--;
            }
            while (startCol < col){
                sb.append("R");
                startCol++;
            }
            while (startCol > col){
                sb.append("L");
                startCol--;
            }
            while (startRow < row){
                sb.append("D");
                startRow++;
            }
            sb.append("!");
           startRow = row;
           startCol = col;
        }
        System.out.println(sb.toString());
    }
}
// DRR!U!DDDRR!UUR!!DDRR!UUU!DRR!D!UU!DDRRR!
