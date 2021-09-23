package com.chenhao.web.controllers;

import com.chenhao.common.utils.FileCacheUtil;
import com.chenhao.dto.BaseResponse;
import com.chenhao.service.IFileService;
import com.chenhao.service.config.BlogFileConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * @description:文件相关控制器
 * @author: chenhao
 * @date: 2021-6-4 13:42
 */
@Controller
@RequestMapping(value = "file")
@Api(value = "文件服务", tags = {"文件服务集合"})
public class FilesController {

    @Autowired
    private IFileService fileService;

    /**
     * 根据文件类别去上传文件，具体的文件类型
     *
     * @param files
     * @param type
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ApiOperation("文件上传")
    @ResponseBody
    public BaseResponse uploadFile(@RequestParam("files") MultipartFile[] files, @RequestParam("type") Integer type) throws Exception {
        return new BaseResponse(fileService.upload(files, type));
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    @ApiOperation("文件下载")
    @ResponseBody
    public void downloadFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws Exception {
        File downloadFile;
        //先从缓存中拿，拿不到再从本地磁盘中加载
        downloadFile = FileCacheUtil.getInstance().getFileCached(fileName);
        if(downloadFile==null){
        downloadFile = fileService.downloadFile(fileName);
        }
        InputStream is = new BufferedInputStream(new FileInputStream(downloadFile));
        response.reset();
        response.setHeader("Content-Length", "" + is.available());
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + new

                String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        byte[] b = new byte[4096];
        int count;
        while ((count = is.read(b)) != -1) {
            os.write(b, 0, count);
        }
        is.close();
        os.close();
        os.flush();
    }

}
