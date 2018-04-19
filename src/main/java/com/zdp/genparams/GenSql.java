package com.zdp.genparams;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dapeng.zhou on 2016/4/8.
 */
public class GenSql {
    public static void main(String[] args) throws Exception {
//        for(int i=0;i<100;i++) {
//            System.out.println("select count(*) from  coupon_dis_entity_" + i + "  where item_id in (936,939) and coupon_status=1 and create_time>'2016-04-07 16:41' and " +
//                    " create_time<'2016-04-08 19:51:24';" );
//        }
//        InputStream in = new FileInputStream("D:\\revert.txt");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        String line = null;
//        while (true) {
//            line = reader.readLine();
//            if (StringUtils.isEmpty(line)){
//                continue;
//            }
////            System.out.println(line);
//            String[] keys = line.split(",");
//            int index = Integer.valueOf(keys[0].substring(keys[0].length()-2),36);
//            String srcOrderId = keys[1];
//            System.out.println("select coupon_code,user_phone,src_order_id,create_time from coupon_dis_entity_" + index + " where item_id in (936,939) and coupon_status=1 and src_order_id='" + srcOrderId + "';");
            for(int i=0;i<100;i++) {
                String sql = "select count(distinct(user_phone)) from coupon_dis_entity_"+i+" where item_id in (929,931,935,942,943,944,945,946,948,949,951,959,962,971,973) and coupon_status=6 and user_phone not in (select distinct(user_phone) from coupon_dis_entity_"+0+" where item_id in (929,931,935,942,943,944,945,946,948,949,951,959,962,971,973) and coupon_status in (2,4));";
                System.out.println(sql);
            }
        }
    }
//}
