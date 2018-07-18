package com.newbee.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@Api(value = "获取openid")
public class GetOpenid {

    @ResponseBody
    @RequestMapping(value = "/getOpenid",method = RequestMethod.POST)
    @ApiOperation(value = "获取openid",httpMethod = "Post")
    public String getOpenid(@RequestParam String code){
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        //替换appid，appsecret，和code
        String requestUrl = WX_URL.replace("APPID", "wx7be692458701605f").//填写自己的appid
                replace("SECRET", "9cc40d58d55aedb59cd5bcffe346ac19").replace("JSCODE", code).//填写自己的appsecret，
                replace("authorization_code", "authorization_code");
        String retValue = GET(requestUrl);

        log.info("请求路径★★★★★★★★："+requestUrl);
        log.info("返回值★★★★★★★★："+retValue);

        JSONObject json = new JSONObject();

        json = (JSONObject) JSON.parse(retValue);

        log.info("return openid is★★★★★★★★ ："+(String)json.get("openid"));
        log.info("return sessionkey is★★★★★★★★ ："+(String)json.get("session_key"));

        String openid = (String)json.get("openid");
        String sessionkey = (String)json.get("sessionkey");
        return openid;
    }


    //发起get请求的方法。
    public  String GET(String url) {
        String result = "";
        BufferedReader in = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            // 异常记录
            log.error("获取openid失败"+e.getStackTrace());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e2) {
                // 异常记录
            }
        }
        return result;
    }
}


    /*此方法没有用到。就先放在这吧
	public static String jedisOperate(String Session_key, String openid) {
		//这里需要引入一下jedis的dependenicy
		Jedis jedis = new Jedis("localhost");
		String openid = openid;
		String session_key = session_key;
		String uid = UUID.randomUUID().toString();
		StringBuffer sb = new StringBuffer();
		sb.append(openid);
		sb.append(","+session_key);
		jedis.set(uid, sb.toString());
		return uid;
		//如果需要获取登录用户的用户名和昵称，我们就需要注意一个问题，如果昵称中有中文就会出现乱码，这是因为微信对于中文是按照ISO-8859-1来进行编码的而我们需要的utf8编码，对于获取用户昵称出现乱码这个问题我们做一下简单的处理就可以解决：
		//String nickNameDecode = new String(nickName.getBytes("ISO-8859-1"),"utf-8");
	*/
