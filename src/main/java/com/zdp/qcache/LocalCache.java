package com.zdp.qcache;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public interface LocalCache {
    void set(String key,String value);

    String get(String key);
}
