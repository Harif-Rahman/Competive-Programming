public class DefangAnIpAddress1108 {

    public static void main(String[] args) {
        System.out.println(defainfIPAddr1("1.1.1.1"));
    }
    public static String defangIPaddr(String address) {
        address = address.replaceAll("\\.","[.]");
        return address;
    }
    private static String defainfIPAddr1(String address){
        String str = new String();
        for(char c : address.toCharArray()){
            if(c == '.'){
                str +="[.]";
            }else{
                str+=c;
            }

        }
        return str;
    }
    private static String defangIPaddr2(String address) {
        for (int i = address.length() - 2; i >= 0; i--)
            if (address.charAt(i+1) == '.')
                address = address.substring(0, i + 1) + "[.]" + address.substring(i + 2);
        return address;
    }
}
