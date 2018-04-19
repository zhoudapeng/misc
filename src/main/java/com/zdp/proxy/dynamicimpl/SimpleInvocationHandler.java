package com.zdp.proxy.dynamicimpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月10日 下午5:45:53
 */
public class SimpleInvocationHandler <T> implements InvocationHandler{
    
    public T t;
    
    public SimpleInvocationHandler(T t){
        this.t = t;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[JdkProxy] do something before invoke " + method.getName());
        Object obj = null;
        try{
            obj = method.invoke(t, args);
        }catch(Exception e){
            System.out.println("[JdkProxy] do something when throw excption");
        }finally{
            System.out.println("[JdkProxy] do something after invoke "+method.getName());
        }
        return obj;
    }
    
}
