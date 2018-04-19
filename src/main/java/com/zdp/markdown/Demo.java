package com.zdp.markdown;

import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;

/**
 * Created by dapeng.zhou on 2016/7/6.
 */
public class Demo {
    public static void main(String[] args) {
        try {
//            String html = new Markdown4jProcessor().process("This is a **bold** text");
//            System.out.println(html);
            for (int i=0;i<=100;i++) {
                String str = "update coupon_dis_entity_"+i+" set validity_end_time='2016-07-13 23:59:59' where coupon_status=1 and item_id in (985,986,987);";
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
