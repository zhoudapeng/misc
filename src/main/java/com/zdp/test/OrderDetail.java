package com.zdp.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年1月19日 下午3:40:42
 */
public class OrderDetail {
    private String tokenNo;
    private String orderbusiOrderno;
    public String getTokenNo() {
        return tokenNo;
    }
    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }
    public String getOrderbusiOrderno() {
        return orderbusiOrderno;
    }
    public void setOrderbusiOrderno(String orderbusiOrderno) {
        this.orderbusiOrderno = orderbusiOrderno;
    }
    
    public static void main(String[] args) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("orderId", "1153525210");
        System.out.println(URLEncoder.encode(obj.toString(), "utf-8"));
        OrderMoney o1 = new OrderMoney(2,30.2);
        OrderMoney o2 = new OrderMoney(1,40.3);
        List<OrderMoney> list = Arrays.asList(o1,o2);
        String str = JSONArray.fromObject(list).toString();
        System.out.println(str);
        System.out.println(URLEncoder.encode(str, "utf-8"));
        
    }
}
