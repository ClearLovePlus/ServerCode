package com.chenhao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @description:文件服务
 * @author: chenhao
 * @date: 2021-6-4 14:07
 */
public interface IFileService {
    /**
     * 文件上传
     * @param files
     * @param type
     * @return
     * @throws Exception
     */
    Boolean upload(MultipartFile[] files,Integer type) throws Exception;

    /**
     * 文件下载
     * @param fileName
     * @return
     * @throws Exception
     */
    File downloadFile(String fileName) throws Exception;
}
