package com.zdp.qcache;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class MonitorCacheEnhancer implements CacheEnhancer {
    private static CacheEnhancer instance = new MonitorCacheEnhancer();
    public static CacheEnhancer getInstance() {
        return instance;
    }

    public void onBefore() {
        System.out.println(MonitorCacheEnhancer.class + " onBefore");
        CacheContext.getMap().put("startTime",System.currentTimeMillis());
    }

    public void onAfter() {
        System.out.println(MonitorCacheEnhancer.class + " onAfter");
    }

    public void onException(Exception e) {
        System.out.println(MonitorCacheEnhancer.class + " onException");
    }

    public void onComplete() {
        System.out.println(MonitorCacheEnhancer.class + " onComplete");
        long startTime = (Long) CacheContext.getMap().get("startTime");
        long now = System.currentTimeMillis();
        System.out.println(MonitorCacheEnhancer.class + " timeclapse = " + (now - startTime));
        CacheContext.clear();
    }
}
