package com.zdp.demo;

import java.io.*;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年5月5日 下午10:10:37
 */
public class Demo {
    public static void main(String[] args) throws Exception {
//        for(int i=0;i<1000;i++){
//            System.out.println(System.currentTimeMillis());
//            i++;
//            i++;
//            i++;
//            i++;
//        }
//        String fmt = "{1}元您获得{0}张的车车代金券";
//        String str = MessageFormat.format(fmt,1,2);
//        System.out.println(str);
//        System.out.println("186=Sd00120".hashCode()%100);
//        System.out.println(Integer.valueOf("2M",36));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\node.txt")));
//        String line = null;
//        StringBuilder sb = new StringBuilder();
//        while((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        System.out.println(URLDecoder.decode(sb.toString(),"utf-8"));
//        Calendar cal = new GregorianCalendar();
//        cal.add(Calendar.DAY_OF_MONTH,7);
//        System.out.println(cal.getTime());
        System.out.println(Integer.valueOf("1Z",36));
        System.out.println(UUID.randomUUID());
        String t = "ab";
        String other = "b";
        String a = new StringBuffer("a").append(other).toString();
//        System.out.println("ab");
//        System.out.println(a == "ab");
        System.out.println(a == a.intern());
        System.out.println(a == "ab");
//        a.intern();
//        String b = "ab";
//        System.out.println(a == b);
//        System.out.println(Integer.valueOf("2L",36));
        if (true) {
            return;
        }
        String[] itemIds = {"1523","1522","1521","1520","1519","1518"};
        String[] serviceTypes = {"14","15","16","17"};
        for (String itemId:itemIds) {
            for (String serviceType:serviceTypes) {
                System.out.println(String.format("insert into coupon_dis_srv(item_id,car_srv_type,create_time) values (%s,%s,now());",itemId,serviceType));
            }
        }
        for (String itemId:itemIds) {
            System.out.println("insert into coupon_dis_biz(item_id,car_biz_type,create_time) values(" + itemId +",8,now());");
        }
        System.out.println("update coupon_dis_item set avail_srv=concat(avail_srv,' 超级巴士送机 超级巴士接机 超级巴士送火车站 超级巴士接火车站'),avail_biz=concat(avail_biz,' 直通车') where item_id in (" + combine(itemIds) + ");");
//        System.out.println("update coupon_dis_item set par_value_amount=0,free_km_count=20 where item_id=1509;");
    }

    private static String combine(String[] itemIds) {
        StringBuilder sb = new StringBuilder();
        for (String itemId:itemIds) {
            sb.append(itemId).append(",");
        }
        return sb.substring(0,sb.length() - 1);
    }
}
