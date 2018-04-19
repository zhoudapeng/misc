package com.zdp.proxy.dynamicimpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.zdp.proxy.ProxyFactory;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月10日 下午6:36:30
 */
public class JdkProxyFactory <T> implements ProxyFactory<T>{
    
    private T t;
    public JdkProxyFactory(T t){
        this.t = t;
    }
    
    public T getProxy() {
        InvocationHandler handler = new SimpleInvocationHandler(t);
        T proxy = (T) Proxy.newProxyInstance(SimpleInvocationHandler.class.getClassLoader(), t.getClass().getInterfaces(), handler);
        return proxy;
    }

}
