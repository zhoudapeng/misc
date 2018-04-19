package com.zdp.proxy;

import com.zdp.proxy.dynamicimpl.CglibProxyFactory;
import com.zdp.proxy.dynamicimpl.JdkProxyFactory;
import com.zdp.proxy.staticimpl.StaticProxyFactory;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月10日 下午8:39:51
 */
public class ProxyUtil{
    public static Task getProxy(Task task, ProxyType type) {
        switch (type) {
        case STATIC: {
            return new StaticProxyFactory(task).getProxy();
        }
        case JDK: {
            return new JdkProxyFactory<Task>(task).getProxy();
        }
        case CGLIB: {
            return new CglibProxyFactory<Task>(task).getProxy();
        }
        }
        return null;
    }
    
}
