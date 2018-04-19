package com.zdp.threadmodel.nio.netty.like;

/**
 * Created by dapeng.zhou on 2017/4/6.
 */
public  interface  Allocatable <T> {
    void allocate(T t);
}
