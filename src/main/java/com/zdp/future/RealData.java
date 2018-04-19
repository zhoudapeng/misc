package com.zdp.future;

/**
 * Created by dapeng.zhou on 2016/9/30.
 */
public class RealData implements Data {
    private String str;
    public RealData(String str) {
        this.str = str;
    }
    public String getResult() {
        return str;
    }
}
