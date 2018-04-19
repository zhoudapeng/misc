package com.zdp.qcache;


import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class CacheWrapper {
        public static Object getWrapper(Object target,Mode mode) {
            CacheInterceptor interceptor = new CacheInterceptor(mode.getEnhancerList());
            ProxyFactory factory = new ProxyFactory();
            factory.setInterfaces(target.getClass().getInterfaces());
            factory.setTargetClass(target.getClass());
            factory.setTarget(target);
            factory.addAdvice(interceptor);
            return factory.getProxy();
        }
}
