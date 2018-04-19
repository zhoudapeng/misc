package com.zdp.proxy.staticimpl;

import com.zdp.proxy.ProxyFactory;
import com.zdp.proxy.Task;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月10日 下午5:24:35
 */
public class StaticProxyFactory implements Task,ProxyFactory<Task>{
    
    private Task task;
    
    public StaticProxyFactory(Task task){
        this.task = task;
    }

    public void doTask(String str) {
        System.out.println("[StaticProxy] do something before invoke doTask");
        try{
            task.doTask(str);
        }catch(Exception e){
            System.out.println("[StaticProxy] do something when throw exception");
        }finally{
            System.out.println("[StaticProxy] do something after invoke doTask");
        }
    }

    public Task getProxy() {
        return this;
    }

}
