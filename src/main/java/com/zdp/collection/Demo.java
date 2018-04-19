package com.zdp.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dapeng.zhou on 2016/6/30.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        List<String> datas = new ArrayList<String>();
        datas.add("a");
        datas.add("b");
        datas.add("d");
        datas.add("c");
        Field field = datas.getClass().getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] objects = (Object[])field.get(datas);
        for (Object object:objects) {
            System.out.println(object);
        }
        objects[0] = "我改的";
        System.out.println(datas);
//        for (String data:datas) {
//            System.out.println(data);
//            if (data.equals("b")) {
//                datas.remove(data);
//            }
//        }
//        System.out.println(datas);
//        Iterator<String> iterator = datas.iterator();
//        while (iterator.hasNext()) {
//            String data = iterator.next();
//            if (data.equals("b")) {
//                iterator.remove();
//            }
//        }
//        System.out.println(datas);
    }
}
