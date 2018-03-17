package httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发送http请求
 * 可以发送GET,POST,PUT,DELETE四种格式的请求，也可以发送带文件的请求
 *
 */
public class HttpRequest {
	
	/**
	 * 向服务器发送GET请求
	 * 
	 * @param url
	 *            请求的主机接口地址
	 * @param params
	 *            封装后的请求数据
	 * @return 响应的json字符串
	 */
	public static String sendRequestGet(String url , HashMap<String, Object> params) throws Exception{

		CloseableHttpClient httpClient = HttpClients.createDefault();
        StringBuffer urlBuffer = new StringBuffer(url);
		StringBuffer paramsBuffer = new StringBuffer(20);
        String requestUrl;
		//封装参数到url
		for (Map.Entry<String, Object> entry :params.entrySet()){
		    paramsBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        if (paramsBuffer.length()>0){
		    requestUrl = urlBuffer.append("?").append(paramsBuffer.substring(0, paramsBuffer.length()-1)).toString();
        }else{
		    requestUrl = urlBuffer.toString();
        }

		HttpGet get = new HttpGet(requestUrl);
        CloseableHttpResponse response = httpClient.execute(get);
		try{
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity,"UTF-8");
			EntityUtils.consume(entity); // and ensure it is fully consumed
			return content;
		}finally {
			httpClient.close();
			response.close();
		}
	}

	/**
	 * 将参数封装为json格式，向服务器发送POST请求（由于大多数接口使用的都是POST方法）
	 * 
	 * @param url
	 *            请求的主机接口地址
	 * @param params
	 *            封装后的请求数据
	 * @return 响应的json字符串
	 */
	public static String sendRequestPost(String url, HashMap<String, String> params) throws  Exception{

		CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();

        for (Map.Entry<String, String> entry :params.entrySet()){
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        StringEntity s= new UrlEncodedFormEntity(nvps);
        s.setContentEncoding("UTF-8");
        post.setEntity(s);
        CloseableHttpResponse response = httpclient.execute(post);

		try {
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			EntityUtils.consume(entity); // and ensure it is fully consumed
			return content;
		}finally {
			httpclient.close();
			response.close();
		}
	}
}
