package com.zdp.cache;

/**
 * Created by dapeng.zhou on 2016/5/10.
 */
public interface LoadingCache <K extends Identifyable,V>{
    public V load(K key);
}
