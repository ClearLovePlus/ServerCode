package com.chenhao.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 令牌桶限流算法
 * @author: chenhao
 * @date: 2021-11-29 16:22
 */
public class RateLimiter {

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
     * 隔个多少毫秒生成令牌
     */
    private final long timeUnit;
    /**
     * 限流器启动的时间
     */
    private final long rateLimiterStartTime;
    /**
     * 下一次应该产生令牌的时间
     */
    private long nextCreateBudgetTime;
    /**
     * 当前令牌桶中令牌为空
     */
    private static final int EMPTY=0;
    /**
     * 限流器构造函数
     * @param budgetCapacity
     */
    public RateLimiter(int budgetCapacity,int unitBudget,long timeUnit){
        this.budgetCapacity=new AtomicInteger(budgetCapacity);
        this.currentCapacity=new AtomicInteger(budgetCapacity);
        this.unitBudget=unitBudget;
        this.timeUnit=timeUnit;
        this.rateLimiterStartTime=System.currentTimeMillis();
        this.nextCreateBudgetTime=rateLimiterStartTime+timeUnit;
    }

    /**
     * 获取令牌
     * @param acquireTokenNum 每次需要获取几个令牌
     * @return
     */
    public boolean acquire(int acquireTokenNum){
        //当前准备对外提供的令牌
        if(acquireTokenNum>this.currentCapacity.get()){
            return false;
        }
        synchronized (this){
            long currentAcquireTime=System.currentTimeMillis();
            this.refreshBudget(currentAcquireTime);
            if(acquireTokenNum<=currentCapacity.get()){
                doAcquire(acquireTokenNum);
                return true;
            }
        }
        return false;
    }

    /**
     * 刷新令牌的数量，不用单开一个线程去维护令牌桶的容量
     * @param acquireTime
     */
    private void refreshBudget(long acquireTime){
        if(currentCapacity.get()>=budgetCapacity.get()){
            return;
        }
        if(acquireTime<this.nextCreateBudgetTime){
            return;
        }
        int futureCapacity=this.currentCapacity.getAndAdd(unitBudget);
        if(futureCapacity>budgetCapacity.get()){
            return;
        }
        this.currentCapacity=new AtomicInteger(futureCapacity);
        //刷新下一次啊生成令牌的时间
        this.nextCreateBudgetTime=nextCreateBudgetTime+timeUnit;
    }

    /**
     * 真正的获取令牌的方法
     * @param needTokenNum
     * @return
     */
    private boolean doAcquire(int needTokenNum){
        int nextCapacity=this.currentCapacity.get()-needTokenNum;
        this.currentCapacity=new AtomicInteger(nextCapacity);
        return true;
    }
}
