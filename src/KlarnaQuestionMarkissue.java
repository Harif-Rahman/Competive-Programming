import java.nio.charset.StandardCharsets;

public class KlarnaQuestionMarkissue {

    public static void main(String[] args) {

        String example = "If £ ¬ you သည္အလုပ္လာေရာက္ေလွ်ာက္ထားstill need \uD83D\uDE0Eassistance, you`re always welcome to chat with us again. Have a great day! \uD83D\uDE0A\uD83D\uDE02 <b> google < /b>";
        byte[] bytes = example.getBytes();

        System.out.println("Text : " + example);
        System.out.println("Text [Byte Format] : " + bytes);
        // no, don't do this, it returns the address of the object in memory
        System.out.println("Text [Byte Format] : " + bytes.toString());

        // convert bytes[] to string
        String s = new String(bytes);
        System.out.println("Output : " + s);

        // UnsupportedEncodingException
        //String s = new String(bytes, "UTF_8");

    }
}
