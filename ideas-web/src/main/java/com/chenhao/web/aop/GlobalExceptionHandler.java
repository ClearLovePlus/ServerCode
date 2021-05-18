package com.chenhao.web.aop;

import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.exception.SystemException;
import com.chenhao.dto.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 全局异常处理，以throw exception方式处理异常
 * @author: chenhao
 * @date: 2021-1-7 14:09
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理业务异常
     * @param be
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResponse businessException(BusinessException be){
      logger.info(String.format("业务异常:%s",be.getMsg()),be);
      BaseResponse result=new BaseResponse(be.getErrorCode(),be.getMsg());
      return result;
    }

    /**
     * 处理系统异常
     * @param se
     * @return
     */
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public BaseResponse systemException(SystemException se){
        logger.error(String.format("系统发生异常：%s",se.getMsg()),se);
        BaseResponse result=new BaseResponse(se.getErrorCode(),se.getMsg());
        return result;
    }

    /**
     * 处理其他未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse anotherException(Exception e){
        logger.error(String.format("发生未知异常：%s",e.getMessage()),e);
        BaseResponse result=new BaseResponse(-500,"unknow error");
        return result;
    }
}
