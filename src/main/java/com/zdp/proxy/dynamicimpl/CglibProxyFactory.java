package com.zdp.proxy.dynamicimpl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.zdp.proxy.ProxyFactory;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月10日 下午6:22:23
 */
public class CglibProxyFactory <T> implements MethodInterceptor,ProxyFactory<T>{
    
    private T t;
    
    public CglibProxyFactory(T t){
        this.t = t;
    }

    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
        System.out.println("[CglibProxy] do something before invoke " + method.getName());
        Object obj = null;
        try{
            obj = method.invoke(t, args);
        }catch(Exception e){
            System.out.println("[CglibProxy] do something when throw exception");
        }finally{
            System.out.println("[CglibProxy] do something after invoke " + method.getName());
        }
        return obj;
    }

    public T getProxy() {
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(t.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return (T) enhancer.create();  
    }
    
}
