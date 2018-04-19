package com.zdp.test;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年8月4日 下午3:41:05
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
//        String str = "阿坝 白山 北海 北京 长春 长沙 常州 成都 重庆 大理 大连 大同 福州 广州 桂林 贵阳 哈尔滨 海口 杭州 合肥 黄山 呼和浩特 济南 昆明 兰州 丽江 柳州 南昌 南京 南宁 宁波 青岛 泉州 三亚 上海 沈阳 深圳 石家庄 苏州 太原 天津 温州 武汉 乌鲁木齐 无锡 厦门 西安 西宁 西双版纳 延边 宜昌 银川 郑州 舟山 珠海";
//        System.out.println(str.replaceAll(" ", ","));
//        Calendar cal = new GregorianCalendar();
//        cal.add(Calendar.HOUR_OF_DAY, 1);
//        System.out.println(cal.getTimeInMillis());
//        cal.add(Calendar.HOUR_OF_DAY, 4);
//        System.out.println(cal.getTimeInMillis());
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("e:\\status.txt"), "utf-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("e:\\update.sql")));
        String str = null;
        int succCount = 0;
        while ((str = reader.readLine()) != null) {
            String[] datas = str.split("\t");
            if (datas.length != 2) {
                continue;
            }
            String channelTransId = "'" + datas[0];
            if (datas[1].equals("DELIVRD")) {
                String sql = "update trans_send_detail set trans_status='A001' where channel_id='1303' and trans_date='2017-08-24' and trans_id=" + channelTransId + ";";
                writer.write(sql);
                writer.newLine();
            }
        }
        writer.flush();
        writer.close();
        System.out.println("end...");
    }
}
