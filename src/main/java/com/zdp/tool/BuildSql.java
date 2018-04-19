package com.zdp.tool;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by dapeng.zhou on 2017/3/13.
 */
public class BuildSql {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String fmt = " insert into coupon_dis_srv(item_id,car_srv_type,create_time) values(%s,%s,now());";
//        for (String itemId:"936,937,938,939,1309,1310".split(",")) {
//            for (int i=3;i<=5;i++) {
//                System.out.println(String.format(fmt,itemId,i));
//            }
//        }
        System.out.println(Integer.valueOf("0W",36));
        System.out.println(URLEncoder.encode("http://car.qunar.com/h5/activity/419sale/99sale.html","utf-8"));
        System.out.println(URLEncoder.encode("http://car.qunar.com/h5/activity/419sale/15sale.html","utf-8"));
        System.out.println("坝 鞍山 白山 包头 北京 北海 保定 宝鸡 本溪 长沙 成都 常州 长春 重庆 承德 沧州 大庆 大连 大理 敦煌 东莞 大同 丹东 鄂尔多斯 鄂州 福州 佛山 贵阳 广州 桂林 哈尔滨 黄山 海口 杭州 呼伦贝尔 合肥 呼和浩特 衡阳 湖州 惠州 济宁 济南 九江 吉林 嘉兴 昆明 连云港 兰州 柳州 丽江 临沂 拉萨 洛阳 龙岩 丽水 乐山 娄底 绵阳 宁波 南昌 南宁 南京 齐齐哈尔 青岛 秦皇岛 衢州 泉州 曲靖 深圳 沈阳 上海 三亚 苏州 石家庄 邵阳 绍兴 汕头 台州 天津 唐山 太原 泰安 武汉 无锡 芜湖 威海 乌鲁木齐 温州 西安 咸阳 徐州 西宁 西双版纳 厦门 银川 宜昌 烟台 运城 延边 岳阳 扬州 珠海 郑州 舟山 遵义 中山".split(" ").length);
//        for (int i=0;i<100;i++) {
//            System.out.println("select coupon_code,src_order_id,create_time,book_time from coupon_dis_entity_" + i + " where coupon_status in (2,4) and item_id in (939,938,937,936,1000,1043,1081,1241,1178,1081,1241,1178,1310,1309,1308,1250);");
//        }
    }
}
