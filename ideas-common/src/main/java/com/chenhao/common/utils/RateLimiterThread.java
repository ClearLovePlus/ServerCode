package com.chenhao.common.utils;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-11-29 17:26
 */
public class RateLimiterThread implements Runnable {
    private RateLimiter rateLimiter;

    public RateLimiterThread(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public void run() {
        boolean acquired = rateLimiter.acquire(1);
        if (acquired) {
            System.out.println("我拿到了通行证啦>_<!");
        } else {
            System.out.println("我再等等吧");
        }
    }
}
