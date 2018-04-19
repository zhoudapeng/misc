package com.zdp.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
@Service
public class MailListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        if (!(event instanceof MailEvent)) {
            System.out.println("翔是过耸过哟,event=" + event);
            return;
        }
        MailEvent mailEvent = (MailEvent) event;
        System.out.println("MailEvent:" + event);
    }
}
