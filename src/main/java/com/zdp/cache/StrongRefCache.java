package com.zdp.cache;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by dapeng.zhou on 2016/10/8.
 */
public class StrongRefCache<K extends Identifyable, V> implements Cache<K, V> {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private volatile Map<K, Future<V>> cache = Maps.newConcurrentMap();
    private LoadingCache<K, V> loadingCache;

    public StrongRefCache(LoadingCache<K, V> loadingCache) {
        this.loadingCache = loadingCache;
    }

    public V get(K key) throws Exception {
        Future<V> future = cache.get(key);
        if (future != null) {
            return future.get();
        }
        if (loadingCache == null) {
            return null;
        }
        synchronized (this) {
            //double check
            if (cache.containsKey(key)) {
                return cache.get(key).get();
            }
            future = load(key);
            cache.put(key, future);
        }
        return future.get();
    }

    public void put(K key, V value) {
        Future<V> future = new SimpleFuture<V>(value);
        cache.put(key, future);
    }

    private Future<V> load(K key) throws Exception {
        Future<V> future = executorService.submit(new LoadingThread<K, V>(loadingCache, key));
        return future;
    }
}


