public class AddDigitsUptoSingleDigit {
    public static void main(String[] args) {

    }
    /*
    principle : any number which is divsior of 9 results to 9

     */
        public int addDigits(int num) {
            if (num == 0){
                return 0;
            }
            if (num % 9 == 0){
                return 9;
            }
            else {
                return num % 9;
            }
        }
}
