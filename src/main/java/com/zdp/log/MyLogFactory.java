package com.zdp.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 下午3:27:41
 */
public class MyLogFactory extends LogFactory{

    @Override
    public Object getAttribute(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getAttributeNames() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Log getInstance(Class clazz) throws LogConfigurationException {
        return getInstance(clazz.getName());
    }

    @Override
    public Log getInstance(String name) throws LogConfigurationException {
//        return new ZdpLogAdapter();
        return null;
    }

    @Override
    public void release() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeAttribute(String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAttribute(String name, Object value) {
        // TODO Auto-generated method stub
        
    }

}
