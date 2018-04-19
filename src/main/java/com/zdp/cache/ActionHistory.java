package com.zdp.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dapeng.zhou on 2016/10/8.
 */
public class ActionHistory implements Serializable{
    private long id;
    private String type;
    private Date date;

    public ActionHistory(long id, String type, Date date) {
        this.id = id;
        this.type = type;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ActionHistory{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
