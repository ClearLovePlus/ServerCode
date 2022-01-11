package com.chenhao.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 令牌桶限流算法，限流器
 * @author: chenhao
 * @date: 2021-11-29 16:22
 */
public class RateLimiter {

    private static final Logger logger = LoggerFactory.getLogger(RateLimiter.class);

    private static volatile RateLimiter rateLimiter;

    /**
     * 桶中的令牌的最大容量
     */
    private final AtomicInteger budgetCapacity;
    /**
     * 桶中当前的令牌
     */
    private volatile AtomicInteger currentCapacity;
    /**
     * 桶中每次新添加几个令牌
     */
    private final int unitBudget;
    /**
     * 隔多少毫秒生成令牌
     */
    private final long timeUnit;
    /**
     * 下一次应该产生令牌的时间
     */
    private long nextCreateBudgetTime;
    /**
     * 当前令牌桶中令牌为空
     */
    private static final int EMPTY = 0;
    /**
     * 锁对象
     * 不能锁class,锁了class在锁竞争的过程中 该class的其他方法也会被锁住
     * 而不是简单的锁住代码块
     */
    private final Object lock=new Object();

    /**
     * 限流器构造函数
     *
     * @param budgetCapacity
     */
    private RateLimiter(int budgetCapacity, int unitBudget, long timeUnit) {
        this.budgetCapacity = new AtomicInteger(budgetCapacity);
        this.currentCapacity = new AtomicInteger(budgetCapacity);
        this.unitBudget = unitBudget;
        this.timeUnit = timeUnit;
        this.nextCreateBudgetTime = System.currentTimeMillis()+ timeUnit;
    }

    /**
     * 单例获取流量控制器
     * @param budgetCapacity
     * @param unitBudget
     * @param timeUnit
     * @return
     */
    public static RateLimiter getInstance(int budgetCapacity, int unitBudget, long timeUnit) {
        if (rateLimiter == null) {
            synchronized (RateLimiter.class) {
                if (rateLimiter == null) {
                    logger.info("RateLimiter is null,start init==>");
                    rateLimiter = new RateLimiter(budgetCapacity, unitBudget, timeUnit);
                    logger.info("RateLimiter is not null,init end==>");
                    return rateLimiter;
                }
            }
        }
        return rateLimiter;
    }

    /**
     * 获取令牌
     *
     * @param acquireTokenNum 每次需要获取几个令牌
     * @return
     */
    public boolean acquire(int acquireTokenNum) {
        //当前准备对外提供的令牌
        synchronized (lock) {
            long currentAcquireTime = System.currentTimeMillis();
            //按照一定的频率往令牌桶中添加令牌
            this.refreshBudget(currentAcquireTime);
            if (acquireTokenNum <= currentCapacity.get()) {
                return doAcquire(acquireTokenNum);
            }
        }
        return false;
    }

    /**
     * 请求完成后归还令牌
     * @param tokenNum
     */
    public void returnToken(int tokenNum){
        synchronized (lock){
            if(this.currentCapacity.get()==this.budgetCapacity.get()){
                return;
            }
            int var=this.currentCapacity.get()+tokenNum;
            if(var>=this.budgetCapacity.get()){
                this.currentCapacity=this.budgetCapacity;
                return;
            }else {
                this.currentCapacity.set(var);
            }
        }
    }

    /**
     * 刷新令牌的数量，不用单开一个线程去维护令牌桶的容量
     *
     * @param acquireTime
     */
    private void refreshBudget(long acquireTime) {
        if (currentCapacity.get() >= budgetCapacity.get()) {
            return;
        }
        if (acquireTime < this.nextCreateBudgetTime) {
            return;
        }
        int futureCapacity = this.currentCapacity.get()+unitBudget;
        if (futureCapacity >= budgetCapacity.get()) {
            this.currentCapacity=budgetCapacity;
            this.nextCreateBudgetTime += timeUnit;
            return;
        }
        logger.info("开始生成令牌");
        this.currentCapacity = new AtomicInteger(futureCapacity);
        logger.info("生成令牌结束,当前令牌数{}", this.currentCapacity.get());
        //刷新下一次啊生成令牌的时间
        this.nextCreateBudgetTime += timeUnit;
    }

    /**
     * 真正的获取令牌的方法
     *
     * @param needTokenNum
     * @return
     */
    private boolean doAcquire(int needTokenNum) {
        if(needTokenNum>this.currentCapacity.get()){
            return false;
        }
        int nextCapacity = this.currentCapacity.get() - needTokenNum;
        this.currentCapacity = new AtomicInteger(nextCapacity);
        return true;
    }
}
