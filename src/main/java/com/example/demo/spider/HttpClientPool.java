package com.example.demo.spider;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientPool {
    public static void main(String[] args) {
        //创建连接池管理器
        PoolingHttpClientConnectionManager manager=new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(20);//设置最大连接数
        //每个访问页面（主页）的最大连接数
        manager.setDefaultMaxPerRoute(5);//每个主机的最大连接数
//        使用连接池管理器发起请求
        doget(manager);
    }

    private static void doget(PoolingHttpClientConnectionManager manager) {
        CloseableHttpClient client= HttpClients.custom().setConnectionManager(manager).build();
        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response=null;
        try {
            response= client.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                System.out.println("请求成功");
                String content= EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            不能关闭HttpClient这里由连接池去管理
        }
    }
}
