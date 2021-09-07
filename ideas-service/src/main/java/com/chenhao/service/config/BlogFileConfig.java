package com.chenhao.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:文件相关配置 该项目尚未接入配置中心 接入配置中心后，可以将相关配置接入配置中心
 * @author: chenhao
 * @date: 2021-6-4 13:50
 */
@Component
@ConfigurationProperties(prefix = "blog.file" )
public class BlogFileConfig {
    private String upload;
    private String prefix;
    private Integer size;

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
