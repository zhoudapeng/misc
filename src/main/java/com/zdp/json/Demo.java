package com.zdp.json;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年3月9日 下午12:18:58
 */
public class Demo {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("t", "car_userui_getMobileNumberByCookies");
        try {
            System.out.println(URLEncoder.encode(obj.toString(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
