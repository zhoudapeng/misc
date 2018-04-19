package com.zdp.genparams;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dapeng.zhou on 2016/4/8.
 */
public class GroupTable {
    public static void main(String[] args) throws Exception {



        InputStream in = new FileInputStream("D:\\codes.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String code = null;
        HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        while(true) {
            code = reader.readLine();
            if (StringUtils.isEmpty(code)) {
                continue;
            }
            String suffix = code.substring(code.length() - 2);
            int index = Integer.valueOf(suffix,36);
            List<String> codes = map.get(index);
            if (codes == null) {
                codes = Lists.newArrayList();
            }
            codes.add(code);
            map.put(index,codes);
            if (StringUtils.equals("1IMRNZ01VBW3P1O",code)) {
                break;
            }
        }
        int count = 0;
        for(int i = 0;i<=100;i++) {
            List<String> codes = map.get(i);
            if (CollectionUtils.isEmpty(codes)){
//                System.out.println(i+"没有数据");
                continue;
            }
            String value = getValue(codes);
//            System.out.println("update coupon_dis_entity_" + i + " set coupon_status=5 where item_id=936 and coupon_status=1 and create_time>'2016-04-07 16:41' and " +
//                    " create_time<'2016-04-08 19:51:24' and coupon_code not in (" + value + ");" );
            System.out.println("select count(*) from coupon_dis_entity_" + i + " where item_id=936 and coupon_status=1 and create_time>'2016-04-07 16:41' and " +
                    " create_time<'2016-04-08 19:51:24' and coupon_code not in (" + value + ");" );
            if (map.get(i) != null) {
                count += map.get(i).size();
            }
        }
//        System.out.println(count);
    }

    private static String getValue(List<String> codes) {
        StringBuilder sb = new StringBuilder();
        for(String code:codes) {
            sb.append("'").append(code).append("'").append(",");
        }
        return sb.substring(0,sb.length() - 1);
    }
}
