package com.zdp.qcache;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public enum Mode {
    ALL(Arrays.asList(MonitorCacheEnhancer.getInstance(),LoggingCacheEnhancer.getInstance())),
    MONITOR(Arrays.asList(MonitorCacheEnhancer.getInstance())),
    LOGGING(Arrays.asList(LoggingCacheEnhancer.getInstance()));
    private List<CacheEnhancer> enhancerList;

    Mode(List<CacheEnhancer> enhancerList) {
        this.enhancerList = enhancerList;
    }

    public List<CacheEnhancer> getEnhancerList() {
        return enhancerList;
    }
}
