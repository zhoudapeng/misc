package com.zdp.pattern.design.service;

/**
 * Created by dapeng.zhou on 2017/4/21.
 */
public class SingleTon {
    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return Inner.instance;
    }

    static class Inner {
       static SingleTon instance = new SingleTon();
    }

    public static void main(String[] args) {
        System.out.println("https://car.qunar.com/h5/activity/51sale/index.html?hybridid=mob_hcar".length());
    }
}
