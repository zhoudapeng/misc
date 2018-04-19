package com.zdp.tool;

/**
 * Created by dapeng.zhou on 2017/3/23.
 */
public interface Processor {
    boolean support(long t1);
    void process();
    int getOrder();
}
