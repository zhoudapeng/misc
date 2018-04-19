package com.zdp.cache;

import java.util.List;

/**
 * Created by dapeng.zhou on 2016/10/8.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        final Cache<User,List<ActionHistory>> cache =
                new CacheBuilder<User,List<ActionHistory>>().
                loadingCache(new ActionHistoryLoadingCache()).
                build();
        //            Cache<User,List<ActionHistory>> cache = new StrongRefLoadingCache<User, List<ActionHistory>>().loadingCache(new ActionHistoryCache());
        final User user = new User("1");
        for(int i = 0;i< 40;i++) {
            new Thread(){
                public void run(){
                    try {
                        System.out.println(cache.get(user));
                    }catch (Exception e) {

                    }
                }
            }.start();
        }
    }
}
