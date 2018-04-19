package com.zdp.demo;

import com.google.common.collect.Maps;

import java.net.URLEncoder;
import java.util.*;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年8月10日 下午3:43:39
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis());
//        System.out.println(1-0.9);
//        System.out.println(1-0.8);
//        System.out.println("186iLIq6503".hashCode());
//        System.out.println(Integer.toString(25850, 16));
//        while(true) {
//            Thread.sleep(2000);
//        }
//        String str = "%7B%22uid%22%3A%224C9ECFA0-2271-401A-ADF0-03ACC7257761%22%2C%22osVersion%22%3A%229.2.1%22%2C%22gid%22%3A%226B10CB01-0523-4366-E1C2-1BF88F704EAB%22%2C%22mac%22%3A%2202%3A00%3A00%3A00%3A00%3A00%22%2C%22pid%22%3A%2210010%22%2C%22aid%22%3A%226A338B34-6772-4A40-A307-19169BCC91CF%22%2C%22vid%22%3A%2280011112%22%2C%22cid%22%3A%22C1001%22%7D";
//        System.out.println(URLDecoder.decode(str,"utf-8"));
        System.out.println(Integer.valueOf("2f", 36));
//        System.out.println(Integer.valueOf("1g", 36));
//        System.out.println(Integer.parseInt("1g", 36));
//        System.out.println("137aZPB6163".hashCode());
//        System.out.println(URLEncoder.encode("北京", "gbk"));
//        String str = "1";
//        for(int i=2;i<=112;i++) {
//            str = str+"," + i;
//        }
//        System.out.println(str);
//        java.util.Map<Integer,Integer> map = Maps.newHashMap();
//        int count = 100000;
//        for(int i = 0;i<count;i++){
//            int n = (int) (60*Math.random());
//            Integer temp = map.get(n);
//            if (temp == null) {
//                temp = 0;
//            }
//            temp++;
//            map.put(n,temp);
////            System.out.println(n);
//        }
//        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
//            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
//        }
//        for (int i = 0; i <= 100; i++) {
//            String sql = "update coupon_dis_entity_" + i + " set validity_end_time=date_add(validity_end_time, interval 15 day) where item_id in (950,951) and coupon_status=1;";
//            System.out.println(sql);
//        }
        System.out.println(URLEncoder.encode("北京","utf-8"));
    }
}
