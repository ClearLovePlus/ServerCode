package com.chenhao.api.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.AppenderBase;
import com.chenhao.api.util.EmailUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-25 17:48
 */
public class MonitorAppender extends AppenderBase<ILoggingEvent> {
    public static final String LEVEL_ERROR = "error";
    /**
     * 接入应用的名称
     */
    private String appName;
    /**
     * 每分钟报错汇总
     */
    private static AtomicInteger errorCountPerMinute=new AtomicInteger(0);
    /**
     * 每分钟的报错内容
     */
    private static ConcurrentHashMap<String, Throwable> errorPerMinuteContent=new ConcurrentHashMap<>();

    public MonitorAppender() {
        startMonitor();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (appName == null || appName.isEmpty()) {
            return;
        }
        if (eventObject == null || StringUtils.isEmpty(eventObject.getMessage())) {
            return;
        }
        String level = eventObject.getLevel().toString();
        if (LEVEL_ERROR.equalsIgnoreCase(level)) {
            errorCountPerMinute.addAndGet(1);
            Throwable throwable = eventObject.getThrowableProxy() != null ? ((ThrowableProxy) eventObject.getThrowableProxy()).getThrowable() : null;
            if (throwable != null) {
                errorPerMinuteContent.put(eventObject.getMessage(), throwable);
            }
        }
    }

    /**
     * 异步去监控每分钟错误数量，达到一定的阈值就发送邮件
     */
    public void startMonitor() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始清理数据");
                int count = errorCountPerMinute.get();
                if (count > 1) {
                    EmailUtils.sendEmail();
                }
                errorCountPerMinute.set(0);
                errorPerMinuteContent.clear();
                System.out.println("结束清理数据");
            }
        }, 1,2, TimeUnit.MINUTES);
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
