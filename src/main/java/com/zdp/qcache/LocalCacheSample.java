package com.zdp.qcache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class LocalCacheSample implements LocalCache{
    private Map<String,String> cache = new ConcurrentHashMap<String,String>();
    public void set(String key,String value) {
        cache.put(key,value);
    }

    public String get(String key) {
        return cache.get(key);
    }
}
