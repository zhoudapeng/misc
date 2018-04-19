package com.zdp.tool;

import java.io.*;

/**
 * Created by dapeng.zhou on 2017/3/10.
 */
public class Util {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data_new.txt"),"utf-8"));
            String line = "";
            int n = 0;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(",");
                String srcOrderId = datas[0];
                String userPhone = datas[1];
                String couponCode = datas[2];
                String tableName = "coupon_dis_entity_" + Integer.valueOf(couponCode.substring(couponCode.length() - 2),36);
                Long itemId = Long.parseLong(datas[3]);
                if (itemId == 939) {
                    System.out.println(String.format("insert into %s(item_id,item_type,multi_avail,par_value_amount,coupon_code,validity_start_time,validity_end_time,scope_limit_flag,costshare_type,costshare_vendor_ratio,user_limit_type,\n" +
                                    "create_time,create_user,coupon_type,user_phone,src_type,src_order_id) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);",tableName,itemId,2,0,70,format(couponCode),
                            format("2017-03-10 00:00:00"),format("2017-05-09 23:59:59"),31,1,0,0,format("2017-03-10 00:00:00"),format("_api"),2,format(userPhone),1,format(srcOrderId)));
                }
                if (itemId == 1081) {
                    System.out.println(String.format("insert into %s(item_id,item_type,multi_avail,par_value_amount,coupon_code,validity_start_time,validity_end_time,scope_limit_flag,costshare_type,costshare_vendor_ratio,user_limit_type,\n" +
                                    "create_time,create_user,coupon_type,user_phone,src_type,src_order_id) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);",tableName,itemId,2,0,90,format(couponCode),
                            format("2017-03-10 00:00:00"),format("2017-05-09 23:59:59"),31,1,0,0,format("2017-03-10 00:00:00"),format("_api"),2,format(userPhone),1,format(srcOrderId)));
                }
                if (itemId == 1250) {
                    System.out.println(String.format("insert into %s(item_id,item_type,multi_avail,par_value_amount,coupon_code,validity_start_time,validity_end_time,scope_limit_flag,costshare_type,costshare_vendor_ratio,user_limit_type,\n" +
                                    "create_time,create_user,coupon_type,user_phone,src_type,src_order_id) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);",tableName,itemId,2,0,0,format(couponCode),
                            format("2017-03-10 00:00:00"),format("2017-05-09 23:59:59"),31,1,0,0,format("2017-03-10 00:00:00"),format("_api"),2,format(userPhone),1,format(srcOrderId)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String format(String input) {
        return "\"" + input + "\"";
    }
}
