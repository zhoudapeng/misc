package com.zdp.proxy.demo;

import com.zdp.proxy.IUser;
import com.zdp.proxy.UserImpl;
import com.zdp.proxy.dynamicimpl.JdkProxyFactory;


/**
 * jdk方式代理实现了接口的类
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月11日 下午2:43:02
 */
public class JdkWithInterfaceDemo {
    public static void main(String[] args) {
        IUser user = new UserImpl();
        IUser proxy = (IUser) new JdkProxyFactory<IUser>(user).getProxy();
        proxy.printName("dapeng.zhou");
        System.out.println("ProxyClass is "+proxy.getClass());
        System.out.println(proxy instanceof IUser);
        System.out.println(proxy instanceof UserImpl);
    }
}
