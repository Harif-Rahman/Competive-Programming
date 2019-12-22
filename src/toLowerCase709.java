public class toLowerCase709 {
    public static void main(String[] args) {
        System.out.println(toLowerCase1("Hello"));
    }
    public static String toLowerCase(String str) {
        String s= new String();
        for(char c : str.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                s += (char)((int) c + 'a' - 'A');
            }else{
                s+=c;
            }
        }
        return s;
    }

    public static String toLowerCase1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (char)(str.charAt(i) | (char)(32));
            sb.append(c);
        }
        return sb.toString();
    }
}
