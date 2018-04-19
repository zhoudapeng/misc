package com.zdp.demo;

/**
 * Created by dapeng.zhou on 2017/4/5.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("150QOwF3944".hashCode());
//        System.out.println("abdc1".matches("ab.c[0-9]+"));
//        for (int i=0;i<100;i++) {
//            System.out.println("delete from coupon_dis_entity_" + i + " where coupon_status=6 and src_type=1 and item_id not in (939,938,937,936,1000,1043,1081,1241,1178,1310,1309,1308,1250,1102,1394,1297,1364,1367,1368,1369,1372,1373,1374,1375,1376,1377,1378,1379,1380,1381,1382,1383,1385,1386,1387,1388,1390,1391,1490,1491,1492,1493,1494,1495,1362,1392,1365,1366,1371,1384,1363,1370,1389,1399,1400,1401,1402,1403,1404,1405,1406,1407,1408,1409,1410,1411,1412,1413,1429,1414,1415,1416,1417,1418,1419,1420,1421,1422,1423,1424,1425,1426,1427,1428) and create_time<'2016-01-01 00:00:00';");
//        }
        System.out.println(Test.class.getClassLoader());
        System.out.println(Test.class.getClassLoader().getParent());
        System.out.println(Test.class.getClassLoader().getParent().getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
