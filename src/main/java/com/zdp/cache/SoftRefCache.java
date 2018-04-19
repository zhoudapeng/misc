package com.zdp.cache;

import com.google.common.collect.Maps;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

/**
 * Created by dapeng.zhou on 2016/5/10.
 */
public class SoftRefCache<K extends Identifyable,V> implements Cache<K,V>{
    private Map<K,SoftValue<K,V>> refCache = Maps.newConcurrentMap();
    private ReferenceQueue<V> queue = new ReferenceQueue<V>();
    private LoadingCache<K,V> loadingCache;

    public V get(K key) {
        clear();
        V value = null;
        if (refCache.containsKey(key)) {
            value = refCache.get(key).get();
        }
        if (value == null) {
            if (loadingCache == null) {
                return null;
            }
            value = loadingCache.load(key);
        }
        SoftValue<K,V> softValue = new SoftValue<K,V>(key,value,queue);
        refCache.put(key,softValue);
        return value;
    }

    public void put(K key, V value) {

    }

    private void clear() {
        SoftValue<K,V> softValue = null;
        while ((softValue = (SoftValue<K,V>) queue.poll()) != null) {
            refCache.remove(softValue.getKey());
        }
    }

    class SoftValue<K extends Identifyable,V> extends SoftReference<V> {
        private K key;
        public SoftValue(K key,V referent, ReferenceQueue<? super V> q) {
            super(referent, q);
            this.key = key;
        }

        public K getKey() {
            return key;
        }
    }

    public SoftRefCache<K,V> loadingCache(LoadingCache<K,V> cache) {
        this.loadingCache = cache;
        return this;
    }

    public static void main(String[] args) {
        LoadingCache<User,List<ActionHistory>> loadingCache = new ActionHistoryLoadingCache();
        SoftRefCache<User,List<ActionHistory>> builder = new SoftRefCache<User,List<ActionHistory>>().loadingCache(loadingCache);
        for(int i=0;i<10;i++){
            User user = new User(i + "");
            List<ActionHistory> histories = builder.get(user);
            System.out.println(histories);
        }
    }

}
