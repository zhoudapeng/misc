package com.zdp.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by dapeng.zhou on 2017/4/17.
 */
public class Demo {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(1);
        while (true) {
            double seconds = limiter.acquire(2);
            System.out.println("wait for " + seconds + " seconds");
        }
    }
}
