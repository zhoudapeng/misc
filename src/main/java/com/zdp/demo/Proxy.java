package com.zdp.demo;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;

/**
 * Created by dapeng.zhou on 2016/12/23.
 */
public class Proxy {
    public static void main(String[] args) {
        System.out.println("aac".replace("/","_"));
        System.out.println("a".substring(1));
        RateLimiter rateLimiter = RateLimiter.create(1);
        System.out.println(new Date());
        while (true) {
            rateLimiter.acquire(5);
            System.out.println(new Date() + "hello");
        }
    }
}
