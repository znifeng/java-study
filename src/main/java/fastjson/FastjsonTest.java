package fastjson;

import com.alibaba.fastjson.JSONObject;

public class FastjsonTest {
    public static void main(String[] args) {
        String jsonString = "{\"code\":200,\"rt\":[{\"cloudEnv\":\"hz\",\"hostname\":\"zni.feng.org\",\"isvm\":1,\"mainIp\":\"10.0.0.1\",\"sn\":1,\"tenantName\":\"myworld\"}]}";
        JSONObject jsonObj = JSONObject.parseObject(jsonString);
        System.out.println(jsonObj.toJSONString());
        System.out.println(jsonObj.get("code").toString());
        System.out.println(jsonObj.getJSONArray("rt").getJSONObject(0).get("mainIp").toString());
    }
}
