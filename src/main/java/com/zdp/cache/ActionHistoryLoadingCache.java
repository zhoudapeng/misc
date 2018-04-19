package com.zdp.cache;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * Created by dapeng.zhou on 2016/5/10.
 */
public class ActionHistoryLoadingCache implements LoadingCache<User, List<ActionHistory>> {
    public List<ActionHistory> load(User user) {
        System.out.println("Loading,key=" + user.getKey());
        List<ActionHistory> histories = Lists.newArrayList();
        histories.add(new ActionHistory(Long.valueOf(user.getKey()),"order",new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return histories;
    }
}
