package com.zdp.test;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年7月8日 下午6:30:03
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        String str = "{\"payInfo\":{\"payTime\":\"\",\"status\":0},\"flightSegments\":[{\"flightNo\":\"CA418\",\"airlineCompany\":\"中国国际航空公司\",\"dpt\":{\"airport\":\"台湾桃园机场\",\"airportCode\":\"TPE\",\"city\":\"台北\",\"cityCode\":\"TPE\",\"ldate\":\"2015-07-23\",\"ltime\":\"19:45\",\"terminal\":\"台北(桃园机场)\"},\"arr\":{\"airport\":\"成都双流国际机场\",\"airportCode\":\"CTU\",\"city\":\"成都\",\"cityCode\":\"CTU\",\"ldate\":\"2015-07-23\",\"ltime\":\"23:35\",\"terminal\":\"成都(双流机场)\"}}],\"orderInfo\":{\"orderNo\":\"hbh150708175657420e4865\",\"id\":27977,\"status\":1,\"contact\":\"XU/HONGJUAN\",\"createTime\":\"2015-07-08 17:57:01\",\"mobCountryCode\":\"86\",\"contactId\":\"18725796445\",\"orderFrom\":\"self\",\"flightType\":\"1\",\"xcd\":false,\"express\":false},\"token\":\"aGJoMTUwNzA4MTc1NjU3NDIwZTQ4NjWFwqV3Mt5wtb67aMtTm2Fw\",\"site\":\"\",\"fromstatus\":0}";
//        System.out.println(str);
//         System.out.println(URLDecoder.decode("/qmq/consumer/subject/car.coupon.send.daley/car.coupondis.manager/qmq%3A%2F%2F192.168.236.219%3A20864%3Freversion%3D1.3.5%26selector%3Dcar.coupon.send.daley%26version%3D1.2.0", "utf-8"));
//         System.out.println(URLEncoder.encode("上海", "utf-8"));
//         String str = "阿坝 白山 北海 北京 长春 长沙 常州 成都 重庆 大理 大连 大同 福州 广州 桂林 贵阳 哈尔滨 海口 杭州 合肥 黄山 呼和浩特 济南 昆明 兰州 丽江 柳州 南昌 南京 南宁 宁波 青岛 泉州 三亚 上海 沈阳 深圳 石家庄 苏州 太原 天津 温州 武汉 乌鲁木齐 无锡 厦门 西安 西宁 西双版纳 延边 宜昌 银川 郑州 舟山 珠海";
//         System.out.println(str.replaceAll(" ", ","));
//         System.out.println("阿坝,成都,北海,济南,石家庄,宜昌,白山,北京,长春,长沙,重庆,大理,大连,大同,福州,广州,桂林,贵阳,哈尔滨,海口,杭州,呼和浩特,昆明,丽江,南京,南宁,宁波,青岛,三亚,上海,沈阳,深圳,太原,天津,武汉,无锡,厦门,西安,西双版纳,延边,郑州,舟山,乌鲁木齐,兰州,银川,西宁,泉州,常州,合肥,黄山,南昌,温州,苏州,九寨沟,柳州,珠海,青岛,昆明,杭州".split(",").length);
//        System.out.println(Integer.valueOf("aa"));
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(0);
        executorService.schedule(new Runnable() {
            public void run() {
                System.out.println("first thread=" + Thread.currentThread());
            }
        },5, TimeUnit.SECONDS);
        executorService.schedule(new Runnable() {
            public void run() {
                System.out.println("second thread=" + Thread.currentThread());
            }
        },5, TimeUnit.SECONDS);
        executorService.schedule(new Runnable() {
            public void run() {
                System.out.println("third thread=" + Thread.currentThread());
            }
        },1, TimeUnit.SECONDS);
    }
}
