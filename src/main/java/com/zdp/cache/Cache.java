package com.zdp.cache;

/**
 * Created by dapeng.zhou on 2016/10/8.
 */
public interface Cache<K extends Identifyable,V> {
    V get(K key) throws Exception;

    void put(K key,V value);
}
