package com.zdp.cache;

import java.util.concurrent.Callable;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
public class LoadingThread<K extends Identifyable,V> implements Callable<V> {
    private LoadingCache<K,V> loadingCache;
    private K key;

    public LoadingThread(LoadingCache<K, V> loadingCache,K key) {
        this.loadingCache = loadingCache;
        this.key = key;
    }

    public V call() throws Exception {
        return loadingCache.load(key);
    }
}
