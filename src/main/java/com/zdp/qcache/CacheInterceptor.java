package com.zdp.qcache;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.List;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
public class CacheInterceptor implements MethodInterceptor {
    private List<CacheEnhancer> enhancerList;

    public CacheInterceptor(List<CacheEnhancer> enhancerList) {
        this.enhancerList = enhancerList;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try {
            for(CacheEnhancer enhancer:enhancerList) {
                enhancer.onBefore();
            }
            result = invocation.proceed();
            for (CacheEnhancer enhancer:enhancerList) {
                enhancer.onAfter();
            }
        }catch (Exception e) {
            for (int i=0;i<enhancerList.size();i++) {
                enhancerList.get(enhancerList.size() -1 - i).onException(e);
            }
        }finally {
            for (CacheEnhancer enhancer:enhancerList) {
                enhancer.onComplete();
            }
        }
        return result;
    }
}
