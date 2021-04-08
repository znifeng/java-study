package base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String password = "zhifeng.nzf@alibaba-inc.com";
        String encode = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
        System.out.println(encode);
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode, "UTF-8"));
    }
}
