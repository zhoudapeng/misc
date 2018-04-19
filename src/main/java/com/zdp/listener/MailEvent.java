package com.zdp.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
public class MailEvent extends ApplicationEvent {
    private String mailfox;
    private String title;
    private String content;

    public MailEvent(Object source, String mailfox, String title, String content) {
        super(source);
        this.mailfox = mailfox;
        this.title = title;
        this.content = content;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never <code>null</code>)
     */
    public MailEvent(Object source) {
        super(source);
    }

    public String getMailfox() {
        return mailfox;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MailEvent{" +
                "mailfox='" + mailfox + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
