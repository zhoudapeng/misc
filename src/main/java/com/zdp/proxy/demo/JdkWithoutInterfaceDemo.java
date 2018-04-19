package com.zdp.proxy.demo;

import com.zdp.proxy.User;
import com.zdp.proxy.dynamicimpl.JdkProxyFactory;

/**
 * jdk方式代理没有实现任何接口的类
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月11日 上午10:33:48
 */
public class JdkWithoutInterfaceDemo {

    public static void main(String[] args) {
        User user = new User();
        try{
            User jdkProxy = new JdkProxyFactory<User>(user).getProxy();
            jdkProxy.printName("dapeng.zhou");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


