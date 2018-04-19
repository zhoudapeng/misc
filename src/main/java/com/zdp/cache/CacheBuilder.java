package com.zdp.cache;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
class CacheBuilder<K extends Identifyable, V> {
    private LoadingCache<K, V> loadingCache;

    public CacheBuilder loadingCache(LoadingCache loadingCache) {
        this.loadingCache = loadingCache;
        return this;
    }

    public StrongRefCache<K, V> build() {
        return new StrongRefCache<K, V>(loadingCache);
    }
}
