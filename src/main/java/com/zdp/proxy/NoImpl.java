package com.zdp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月12日 下午6:50:58
 */
public class NoImpl {
    public static void main(String[] args) {
        Proxy.newProxyInstance(NoImpl.class.getClassLoader(), new Class[]{IUser.class}, new InvocationHandler(){

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.getAnnotation(null);
                String sqlFormat = "";
                return null;
            }});
    }
}
