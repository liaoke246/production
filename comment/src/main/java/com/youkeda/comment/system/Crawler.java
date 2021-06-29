package com.youkeda.comment.system;

import okhttp3  .*;
import org.springframework.stereotype.Service;
import okhttp3.FormBody.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class Crawler {


    // 用 CookieJar 实现 cookie 的存储，便于登录后请求其它 URL 可以复用
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookieStore.put("mtime.com", cookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get("mtime.com");
                    return cookies != null ? cookies : new ArrayList<>();
                }
            })
            .build();

    public String PostContent(String url, Map<String,String> formData) {



        Builder builder = new FormBody.Builder();

        for(String key : formData.keySet()){
            builder.add(key,formData.get(key));

        }
        FormBody formBody = builder.build();
        formData.put("参数名称","参数值");

        Request request = new Request.Builder().url(url).post(formBody)
                .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36")
                .addHeader("Host","www.houqinbao.com")
                .addHeader("X-Requested-With","XMLHttpRequest")
                .build();

        Call call = okHttpClient.newCall(request);

        String result = null;
        try {
            // 获得返回结果
            result = call.execute().body().string();
        } catch (IOException e) {
            // 抓取异常
            System.out.println("request " + url + " error . ");
            e.printStackTrace();
        }
        return result;

    }


    public String  getContent(){

        String url = "http://www.houqinbao.com/hydropower/index.php?m=PayWeChat&c=Index&a=before&payopenid=&openid=oUiRowVf9LEm212UhpyCfXVjl4GM&schoolcode=13579&campusid=13579_173&areaid=13579_173_290&flatid=13579_173_290_956&roomname=A7092";



        Request request = new Request.Builder()
                .url(url)
                .addHeader("Referer","http://www.houqinbao.com/hydropower/index.php?m=PayWeChat&c=Index&a=before&payopenid=&openid=oUiRowVf9LEm212UhpyCfXVjl4GM&schoolcode=13579&campusid=13579_173&areaid=13579_173_290&flatid=13579_173_290_956&roomname=A7092")
                .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36")
                .addHeader("Host","www.houqinbao.com")
                .build();

        String result = null;
        try {
            result = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            // 抓取异常
            System.out.println("request " + request.url() + " error . ");
            e.printStackTrace();
        }

        return result;
    }




}
