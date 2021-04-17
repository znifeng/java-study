import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.taobao.util.CollectionUtil;
import org.apache.kafka.common.utils.CollectionUtils;

public class Test2 {
    class InnerClass{
        void hello(){
            System.out.println("helloworld");
        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String interfaceName = "/api/campaign/{}/forbidden/summary";
        String errorKey = "mainInvoke.responseBody-mainInvoke.features";
        String url1= "https://blizzard.alibaba-inc.com/4859/execute_record_detail/query?recordId=791894&status=11&errorKey="+errorKey+"&invokeIdentity="+ interfaceName+ "&filter=false&pageIndex=1&pageSize=50";
        String url2= "https://blizzard.alibaba-inc.com/4859/execute_record_detail/query?recordId=791894&status=11&errorKey="+URLEncoder.encode(errorKey, "UTF-8")+"&invokeIdentity="+ URLEncoder.encode(interfaceName, "UTF-8")+ "&filter=false&pageIndex=1&pageSize=50";
        System.out.println(url1);
        System.out.println(url2);
        Thread thread = new Runnable(){

            @Override
            public void run() {
                System.out.println("hello");
            }
        }
    }
}
