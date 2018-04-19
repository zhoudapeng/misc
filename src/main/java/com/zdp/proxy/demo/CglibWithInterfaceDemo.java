package com.zdp.proxy.demo;

import com.zdp.proxy.IUser;
import com.zdp.proxy.UserImpl;
import com.zdp.proxy.dynamicimpl.CglibProxyFactory;

/**
 * Cglib方式代理实现接口了的类
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月11日 下午2:54:01
 */
public class CglibWithInterfaceDemo {
    public static void main(String[] args) {
        IUser user = new UserImpl();
        IUser proxy = new CglibProxyFactory<IUser>(user).getProxy();
        proxy.printName("dapeng.zhou");
        System.out.println(proxy.getClass());
        System.out.println(proxy instanceof IUser);
        System.out.println(proxy instanceof UserImpl);
    }
}
