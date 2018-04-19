package com.zdp.qcache;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class CacheContext {
    private static ThreadLocal<Map> context = new ThreadLocal<Map>();

    public static Map getMap() {
        Map map =  context.get();
        if (map == null) {
            map = new HashMap();
            context.set(map);
        }
        return map;
    }

    public static void clear() {
        context.remove();
    }
}
