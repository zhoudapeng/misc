package com.zdp.threadlocal;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年4月17日 下午1:25:47
 */
public class SimpleThreadLocal {
    private static ThreadLocal<String> local = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "1";
        }
    };
    public static void set(String str){
        local.set(str);
    }
    
    public static String get(){
        return local.get();
    }
    
    public static void remove(){
        local.remove();
    }
    
}
