package httpclient;

import java.util.HashMap;

public class test {
    public static void main(String[] args) throws  Exception{
        String urlGet= "http://localhost:9001/test/get";
        HashMap<String, Object> paramsGet = new HashMap<>();
        paramsGet.put("name", "znifeng");
        paramsGet.put("age", 28);
        String resGet = HttpRequest.sendRequestGet(urlGet, paramsGet);
        System.out.println(resGet);

        String urlPost= "http://localhost:9001/test/post";
        HashMap<String, String> paramsPost = new HashMap<>();
        paramsPost.put("name", "znifeng");
        paramsPost.put("age", "28");
        String resPost = HttpRequest.sendRequestPost(urlPost, paramsPost);
        System.out.println(resPost);
    }
}
