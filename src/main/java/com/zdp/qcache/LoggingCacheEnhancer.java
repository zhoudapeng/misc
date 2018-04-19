package com.zdp.qcache;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class LoggingCacheEnhancer implements CacheEnhancer {
    private static LoggingCacheEnhancer instance = new LoggingCacheEnhancer();
    public static CacheEnhancer getInstance() {
        return instance;
    }
    public void onBefore() {
        System.out.println(LoggingCacheEnhancer.class + " onBefore");
    }

    public void onAfter() {
        System.out.println(LoggingCacheEnhancer.class + " onAfter");
    }

    public void onException(Exception e) {
        System.out.println(LoggingCacheEnhancer.class + " onException,e=" + e);
    }

    public void onComplete() {
        System.out.println(LoggingCacheEnhancer.class + " onComplete");
    }
}
