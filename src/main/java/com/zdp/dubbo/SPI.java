package com.zdp.dubbo;

/**
 * Created by dapeng.zhou on 2016/7/4.
 */
public interface SPI {
    public boolean support(String name);

    public Object execute(Object obj);
}
