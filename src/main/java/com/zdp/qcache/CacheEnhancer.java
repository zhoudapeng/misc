package com.zdp.qcache;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public interface CacheEnhancer {
    void onBefore();

    void onAfter();

    void onException(Exception e);

    void onComplete();
}
