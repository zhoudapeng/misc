package com.zdp.test;

import java.util.Collection;
import java.util.List;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月23日 下午2:35:52
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        // int initialCapacity = 4;
        // int numElements = 6;
        // if (numElements >= initialCapacity) {
        // initialCapacity = numElements;
        // initialCapacity |= (initialCapacity >>> 1);
        // initialCapacity |= (initialCapacity >>> 2);
        // initialCapacity |= (initialCapacity >>> 4);
        // initialCapacity |= (initialCapacity >>> 8);
        // initialCapacity |= (initialCapacity >>> 16);
        // initialCapacity++;
        // }
        // System.out.println(initialCapacity);
        // String str =
        // "{\"platform\":\"60001072\",\"orderDetail\":\"{\\\"busiTypeId\\\":\\\"WFLIGHTTTS\\\",\\\"merchantCode\\\":\\\"wirelesstest\\\",\\\"tokenNo\\\":\\\"df66bce2325225497c33600d8967dc43\\\",\\\"orderCreateTime\\\":\\\"1421828442000\\\",\\\"orderbusiOrderno\\\":\\\"0300120150123160000592694\\\",\\\"ordercontactPhone\\\":\\\"**1AQx8u9Riln**\\\",\\\"childbusiOrderno\\\":{\\\"batchOrderNo\\\":\\\"0300120150123160000592694t0001\\\",\\\"childbusiOrderno\\\":[\\\"0300120150123160000592694\\\"],\\\"isMulti\\\":false},\\\"wlBusiTypeId\\\":\\\"WLZUCHE\\\",\\\"orderBusiTypeId\\\":\\\"WLZUCHE\\\",\\\"userId\\\":\\\"\\\",\\\"orderPayStatus\\\":\\\"ACCEPT\\\",\\\"ext\\\":\\\"\\\",\\\"errCode\\\":\\\"\\\",\\\"errMsg\\\":\\\"\\\",\\\"HMAC\\\":\\\"8d239616e2cdf9366de7b79e0047035c\\\"}\",\"token\":\"0db9017300404a1fa9a3beb93310a7de\",\"location\":\"116.319714,39.985421\",\"did\":\"352316057007068\",\"pid\":\"10010\",\"channel\":\"C1001\"}";

        // OrderDetail order = (OrderDetail)
        // JSONObject.toBean(JSONObject.fromObject("{\"orderBusiOrderNo\":\"123\",\"tokenNo\":\"abagkjekgjekgje\",\"orderPayStatus\":\"SUCCESS\"}"),
        // OrderDetail.class);
        // System.out.println(order);
        // System.out.println(URLEncoder.encode("{\"orderBusiOrderNo\":\"123\",\"tokenNo\":\"abagkjekgjekgje\",\"orderPayStatus\":\"SUCCESS\"}",
        // "utf-8"));
        // String str = "{\"cid\":\"2222\"}";
        // System.out.println(URLEncoder.encode(str, "utf-8"));
        // System.out.println(null instanceof String);
        // String str = "";
        System.out.println("hello");
        System.out.println(Long.valueOf("1s", 36));
        System.out.println(Collection.class.isAssignableFrom(List.class));

    }

}
