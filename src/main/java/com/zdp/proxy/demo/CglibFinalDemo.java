package com.zdp.proxy.demo;

import com.zdp.proxy.FinalUser;
import com.zdp.proxy.dynamicimpl.CglibProxyFactory;

/**
 * Cglib代理final类型的类
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月11日 下午3:06:16
 */
public class CglibFinalDemo {
    public static void main(String[] args) {
        FinalUser user = new FinalUser();
        FinalUser proxy = new CglibProxyFactory<FinalUser>(user).getProxy();
        proxy.printName("dapeng.zhou");
    }
}
