package com.zdp.dateformat;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import org.apache.commons.lang.time.FastDateFormat;

/**
@author  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date 2015年9月23日 上午12:15:09
 */
public class TestFastDateFormat {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\需求\\2016-10-11-代金券对账\\对账数据多出的.txt");
        List<String> lines = Files.readLines(file, Charset.defaultCharset());
        Map<String,List<String>> map = Maps.newTreeMap();
        for (String line:lines) {
            String tableMark = line.substring(line.length() - 2);
            List<String> codes = map.get(tableMark);
            if (codes == null) {
                codes = Lists.newArrayList();
                map.put(tableMark,codes);
            }
            codes.add(line);
        }
        System.out.println(map);
        for (Map.Entry<String,List<String>> entry:map.entrySet()) {
            int table = Integer.valueOf(entry.getKey(),36);
//            System.out.println("coupon_dis_entity_" + table);
            List<String> codes = entry.getValue();
            for (String code:codes) {
                System.out.println("select item_id,par_value_amount,src_type,coupon_code,user_phone,coupon_status,src_order_id,create_user,create_time from coupon_dis_entity_" + table + " where coupon_code='"+code+"' ;");
            }
        }
    }
}
