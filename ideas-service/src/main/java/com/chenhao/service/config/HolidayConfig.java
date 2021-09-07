package com.chenhao.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description:该项目尚未接入配置中心 接入配置中心后，可以将相关配置接入配置中心
 * @author: chenhao
 * @date: 2021-7-7 9:25
 */
@Component
@ConfigurationProperties(prefix ="blog.holiday")
public class HolidayConfig {
    private String holidaysWithOutWeekends;
    private String extraWorkDays;

    public String getHolidaysWithOutWeekends() {
        return holidaysWithOutWeekends;
    }

    public void setHolidaysWithOutWeekends(String holidaysWithOutWeekends) {
        this.holidaysWithOutWeekends = holidaysWithOutWeekends;
    }

    public String getExtraWorkDays() {
        return extraWorkDays;
    }

    public void setExtraWorkDays(String extraWorkDays) {
        this.extraWorkDays = extraWorkDays;
    }
}
