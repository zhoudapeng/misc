package com.zdp.genparams;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dapeng.zhou on 2016/4/8.
 */
public class ComputeValidSql {
    public static void main(String[] args) throws Exception{
        InputStream in = new FileInputStream("D:\\err_936.log");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        while(true) {
            line = reader.readLine();
            if (StringUtils.isEmpty(line)) {
                continue;
            }
            String[] keys = line.split(",");
            int suffix = Integer.valueOf(keys[0].substring(keys[0].length() - 2),36);
            String sql = "select coupon_code from coupon_dis_entity_" + suffix + " where coupon_status=1 and create_time>'2016-04-08 19:51:24' and item_id=936 and src_order_id='" + keys[1]+"';";
            System.out.println(sql);
        }
    }
}
