package com.zdp.demo;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by dapeng.zhou on 2016/7/25.
 */
public class CityDiffer {
    public static void main(String[] args) throws Exception{
        Set<String> hotelOnline = hotelOnline();
        Set<String> expectHotel = expectHotel();
        expectHotel.removeAll(hotelOnline);
        System.out.println(expectHotel);
        Set<String> online = online();
        Set<String> expect = expect();
        System.out.println("online:"+online.size());
        System.out.println("expect:"+expect.size());
        expect.removeAll(online);
        System.out.println(expect);
        for (String itemId:"939,938,937,936,1000,997,998".split(",")) {
            System.out.println("insert into coupon_dis_city(item_id,city_code,city_name,create_time) values("+itemId+",'dongguan','东莞',now());");
            System.out.println("insert into coupon_dis_city(item_id,city_code,city_name,create_time) values("+itemId+",'foshan','佛山',now());");
            System.out.println("insert into coupon_dis_city(item_id,city_code,city_name,create_time) values("+itemId+",'shiyan','十堰',now());");
            System.out.println("insert into coupon_dis_city(item_id,city_code,city_name,create_time) values("+itemId+",'xianyang','咸阳',now());");
            System.out.println("insert into coupon_dis_city(item_id,city_code,city_name,create_time) values("+itemId+",'tengchong','腾冲',now());");
            System.out.println("update coupon_dis_item set avail_city=concat(avail_city,' 东莞 佛山 十堰 咸阳 腾冲') where item_id=" + itemId + ";");
        }
        String sb = "";
        for (String temp:"阿坝 白山 北海 北京 长春 长沙 常州 成都 重庆 大理 大连 大同 敦煌 福州 广州 桂林 贵阳 哈尔滨 海口 杭州 合肥 黄山 呼和浩特 呼伦贝尔 济南 昆明 兰州 拉萨 连云港 丽江 柳州 南昌 南京 南宁 宁波 青岛 泉州 三亚 上海 沈阳 深圳 石家庄 苏州 太原 唐山 天津 温州 武汉 芜湖 乌鲁木齐 无锡 厦门 西安 西宁 西双版纳 徐州 延边 烟台 宜昌 银川 郑州 舟山 珠海 遵义 东莞 佛山 十堰 咸阳 腾冲".split(" ")) {
            sb =  sb + "'"+temp + "'"+ ",";
        }
        System.out.println(sb);
    }

    private static Set<String> online() {
        String origData = "阿坝 白山 北海 北京 长春 长沙 常州 成都 重庆 大理 大连 大同 敦煌 福州 广州 桂林 贵阳 哈尔滨 海口 杭州 合肥 黄山 呼和浩特 呼伦贝尔 济南 昆明 兰州 拉萨 连云港 丽江 柳州 南昌 南京 南宁 宁波 青岛 泉州 三亚 上海 沈阳 深圳 石家庄 苏州 太原 唐山 天津 温州 武汉 芜湖 乌鲁木齐 无锡 厦门 西安 西宁 西双版纳 徐州 延边 烟台 宜昌 银川 郑州 舟山 珠海 遵义";
        Set<String> names = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String data:origData.split(" ")) {
            names.add(data);
            System.out.println(data);
        }
        System.out.println("size=" + names.size());
        return names;
    }

    private static Set<String> hotelOnline() throws Exception {
        String origData = "阿坝 白山 北海 北京 长春 长沙 常州 成都 重庆 大理 大连 大同 敦煌 福州 广州 桂林 贵阳 哈尔滨 海口 杭州 合肥 黄山 呼和浩特 呼伦贝尔 济南 昆明 兰州 拉萨 连云港 丽江 柳州 南昌 南京 南宁 宁波 青岛 泉州 三亚 上海 沈阳 深圳 石家庄 苏州 太原 唐山 天津 温州 武汉 芜湖 乌鲁木齐 无锡 厦门 西安 西宁 西双版纳 徐州 延边 烟台 宜昌 银川 郑州 舟山 珠海 遵义";
        Set<String> names = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String data:origData.split(" ")) {
            names.add(data);
            System.out.println(data);
        }
        System.out.println("size=" + names.size());
        return names;
    }

    private static Set<String> expectHotel() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\qunar\\mycode\\src\\main\\java\\com\\zdp\\demo\\all_hotel_city.txt")),"utf-8"));
        String cityName = null;
        int size = 0;
        Set<String> names = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        while (StringUtils.isNotEmpty(cityName = reader.readLine())) {
            size++;
//            System.out.println(cityName);
            names.add(cityName);
        }
        System.out.println("online size=" + size);
        return names;
    }

    private static Set<String> expect() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\qunar\\mycode\\src\\main\\java\\com\\zdp\\demo\\all_flight_city.txt")),"utf-8"));
        String cityName = null;
        int size = 0;
        Set<String> names = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        while (StringUtils.isNotEmpty(cityName = reader.readLine())) {
            size++;
//            System.out.println(cityName);
            names.add(cityName);
        }
        System.out.println("online size=" + size);
        return names;
    }

}
