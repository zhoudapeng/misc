package com.zdp.proxy;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月10日 下午5:23:34
 */
public class TaskImpl implements Task {

    public void doTask(String str) {
        if (str == null || str.length() == 0){
            throw new RuntimeException("what are you doing?");
        }
        System.out.println("[TaskImpl] doTask " + str);
    }

}
