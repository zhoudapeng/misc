package com.zdp.qcache;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class Demo {
    public static void main(String[] args) {
        LocalCache cacheSample = new LocalCacheSample();
        LocalCache wrapperdCache = (LocalCache) CacheWrapper.getWrapper(cacheSample,Mode.ALL);
        wrapperdCache.set("name","qcache");
        wrapperdCache.set("author","dapeng.zhou");
        System.out.println("name=" + wrapperdCache.get("name"));
        System.out.println("author=" + wrapperdCache.get("author"));
    }
}
