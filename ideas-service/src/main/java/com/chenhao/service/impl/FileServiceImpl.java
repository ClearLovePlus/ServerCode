package com.chenhao.service.impl;

import com.chenhao.common.constants.BusinessConstant;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.utils.FileCacheUtil;
import com.chenhao.service.IFileService;
import com.chenhao.service.config.BlogFileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:文件服务实现类
 * @author: chenhao
 * @date: 2021-6-4 14:21
 */
@Service("fileService")
public class FileServiceImpl implements IFileService {
    @Autowired
    private BlogFileConfig blogFileConfig;
    @Override
    public String upload(MultipartFile[] files, Integer type) throws Exception {
        if (files == null || files.length == BusinessConstant.EMPTY) {
            throw new BusinessException(BusinessEnum.FILE_IS_EMPTY);
        }
        if (type == null || type.equals(BusinessConstant.EMPTY)) {
            throw new BusinessException(BusinessEnum.FILE_UN_SUPPORT);
        }
        if(!isAllowedSize(files)){
            throw new BusinessException(BusinessEnum.FILE_SIZE_NOT_ALLOWED.getCode(),String.format(BusinessEnum.FILE_SIZE_NOT_ALLOWED.getMsg(),blogFileConfig.getSize()));
        }
        String result= org.apache.commons.lang3.StringUtils.EMPTY;
        for(MultipartFile file:files){
            SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName=format.format(new Date())+"-"+file.getOriginalFilename();
            File destFile;
            if(fileName.substring(fileName.lastIndexOf(BusinessConstant.POINT)+1).equalsIgnoreCase(BusinessConstant.MP4)){
              destFile = new File(blogFileConfig.getUpload() + "/" +BusinessConstant.VIDEOS+"/"+fileName);
            }else {
             destFile = new File(blogFileConfig.getUpload() +"/"+BusinessConstant.DOCUMENT+"/"+fileName);
            }
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdir();
            }
            file.transferTo(destFile);
            //往本地缓存中存储文件信息
            FileCacheUtil.getInstance().putFileName(file.getOriginalFilename(),fileName);
            result=fileName;
        }
        return result;
    }

    @Override
    public File downloadFile(String fileName) throws Exception {
        if(StringUtils.isEmpty(fileName)){
            throw  new BusinessException(BusinessEnum.FILE_NAME_IS_NULL);
        }
        String filePath;
        if(fileName.substring(fileName.lastIndexOf(BusinessConstant.POINT)+1).equalsIgnoreCase(BusinessConstant.MP4)){
            filePath=blogFileConfig.getUpload() + "/" +BusinessConstant.VIDEOS+"/"+fileName;
        }else {
            filePath=blogFileConfig.getUpload() +"/"+BusinessConstant.DOCUMENT+"/"+fileName;
        }
        File file=new File(filePath);
        //更新本地缓存
        FileCacheUtil.getInstance().putFileSource(fileName,file);
        return file;
    }

    /**
     * 判断文件的大小是否符合要求
     * @param files
     * @return
     */
    private Boolean isAllowedSize(MultipartFile[] files){
        Boolean flag=true;
        for (MultipartFile file:files){
            //允许100M的文件大小
            if(file.getSize()/1024/1024>blogFileConfig.getSize()){
                flag=false;
            }
        }
        return flag;
    }
}
