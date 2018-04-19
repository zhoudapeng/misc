package com.zdp.proxy.demo;

import com.zdp.proxy.User;
import com.zdp.proxy.dynamicimpl.CglibProxyFactory;

/**
 * Cglib方式代理没有实现任何接口的类
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月11日 下午2:40:55
 */
public class CglibWithoutInterfaceDemo {
    public static void main(String[] args) {
        User user = new User();
        try{
            User cglibProxy = new CglibProxyFactory<User>(user).getProxy();
            cglibProxy.printName("dapeng.zhou");
            System.out.println("ProxyClass is "+cglibProxy.getClass());
            System.out.println(cglibProxy instanceof User);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
