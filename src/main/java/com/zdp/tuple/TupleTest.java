package com.zdp.tuple;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by dapeng.zhou on 2017/2/8.
 */
public class TupleTest {
    private boolean best;
    private boolean isAbs;
    private Boolean isOk;
    private Boolean avail;
    private int VOrderId;
    private int qOrderId;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Boolean getAvail() {
        return avail;
    }

    public void setAvail(Boolean avail) {
        this.avail = avail;
    }

    public int getqOrderId() {
        return qOrderId;
    }

    public void setqOrderId(int qOrderId) {
        this.qOrderId = qOrderId;
    }

    public int getVOrderId() {
        return VOrderId;
    }

    public void setVOrderId(int VOrderId) {
        this.VOrderId = VOrderId;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }

    public boolean isAbs() {
        return isAbs;
    }

    public void setAbs(boolean abs) {
        isAbs = abs;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public static void main(String[] args) {
        TwoTuple<String,Integer> twoTuple = new TwoTuple<String, Integer>("abc",123);
        System.out.println(twoTuple);
        List list = Lists.newArrayList();
        for (int i=0;i<100;i++) {
            byte[] arr = new byte[1024 * 1024];
            list.add(arr);
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
