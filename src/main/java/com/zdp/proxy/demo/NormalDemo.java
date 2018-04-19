package com.zdp.proxy.demo;

import com.zdp.proxy.ProxyUtil;
import com.zdp.proxy.ProxyType;
import com.zdp.proxy.Task;
import com.zdp.proxy.TaskImpl;


/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月10日 下午8:23:41
 */
public class NormalDemo {
    public static void main(String[] args) {
        Task task = new TaskImpl();
        for(ProxyType type:ProxyType.values()){
            Task proxy = ProxyUtil.getProxy(task, type);
            proxy.doTask("coding");
            System.out.println("ProxyClass=["+proxy.getClass()+"]");
            System.out.println("--------------");
        }
    }
   
}
