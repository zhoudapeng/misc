package com.zdp.chain;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by dapeng.zhou on 2017/6/14.
 */
public class Context {
    private Map<String,String> context = Maps.newHashMap();
    public void put(String key,String value) {
        context.put(key,value);
    }

    public Map<String,String> get() {
        return context;
    }

    public String toString() {
        return context.toString();
    }
}
