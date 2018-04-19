package com.zdp.qcache;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by dapeng.zhou on 2016/8/11.
 */
public class SedisFactoryBean implements FactoryBean {
    private String namespace;
    private String cipher;
    private String zkAddress;

    public Object getObject() throws Exception {
        return null;
    }

    public Class getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
