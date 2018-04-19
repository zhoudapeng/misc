package com.zdp.cache;

/**
 * Created by dapeng.zhou on 2016/5/10.
 */
public class User implements Identifyable {
    private String id ;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public String getKey() {
        return id ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(id != null ? !id.equals(user.id) : user.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
