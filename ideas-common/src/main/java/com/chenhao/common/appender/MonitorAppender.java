package com.chenhao.common.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-25 17:48
 */
public class MonitorAppender extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent loggingEvent) {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    @Override
    public void close() {

    }
}
