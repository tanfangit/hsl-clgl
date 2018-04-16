package com.hsl.clgl.common.utils;

import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;
/**
 * 短信发送工具类
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-04-11 16:11:44
 */
public class MessageUtils {
    public static String sendMessage(Map<String, Object> params){
        String param = params.get("param").toString();//参数选择
        String phone = params.get("phone").toString();//手机号
        String sign = params.get("sign").toString();//签名
        String skin = params.get("skin").toString();//模板号
        //设置信息暂时写死
        String host = "https://fesms.market.alicloudapi.com";
        String path = "/smsmsg";
        String method = "GET";
        String appcode = "f1a39a42c9354420b91ecb2b1cc7b518";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("param", param);
        querys.put("phone", phone);
        querys.put("sign", sign);
        querys.put("skin", skin);


        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
           return "0";
    }
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("param", "郭靖|12|5000");
        params.put("phone", "15116486770");
        params.put("sign", "1");
        params.put("skin", "1002");
        sendMessage(params);
    }
}
