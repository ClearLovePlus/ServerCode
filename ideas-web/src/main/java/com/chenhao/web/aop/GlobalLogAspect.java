package com.chenhao.web.aop;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.utils.LogFormatter;
import com.chenhao.web.annotions.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * @description:统一日志记录切面
 * @author: chenhao
 * @date: 2021-1-7 14:31
 */
@Aspect
@Component
@Order(100)
public class GlobalLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(GlobalLogAspect.class);

    /**
     * 织入切点
     */
    @Pointcut("@annotation(com.chenhao.web.annotions.Log)")
    public void logAspect() {
    }

    /**
     * 请求之前记录下当前请求的起始时间
     *
     * @param point
     */
    @Before("logAspect()")
    public void before(JoinPoint point) {
        String requestNo = UUID.randomUUID().toString();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        request.setAttribute("requestNo", requestNo);
        logger.info("此次请求开始,序列号是:{}", requestNo);
    }

    /**
     * 环绕执行
     *
     * @param point
     */
    @Around("logAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Log log = methodSignature.getMethod().getAnnotation(Log.class);
        LogFormatter formatter = new LogFormatter();
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            if (sra == null) {
                return point.proceed();
            }
            HttpServletRequest request = sra.getRequest();
            String url = request.getRequestURI();
            String method = request.getMethod();
            Object[] args = point.getArgs();
            Object result = point.proceed();
            Long endTime = System.currentTimeMillis();
            Long startTime = (Long) request.getAttribute("startTime");
            if (args.length > 0) {
                if ("POST".equals(method)) {
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse) {
                            continue;
                        }
                        formatter.setRequest(JSON.toJSONString(args[0]));
                    }
                }
                if ("GET".equals(method)) {
                    formatter.setRequest(JSON.toJSONString(request.getQueryString()));
                }
            }
            Long costTime = endTime - startTime;
            formatter.setMethod(method);
            formatter.setUrl(url);
            formatter.setCostTime(costTime.toString());
            formatter.setResponse(JSON.toJSONString(result));
            formatter.setRequestNo((String) request.getAttribute("requestNo"));
            logger.info("此次请求的日志为:{}", JSON.toJSONString(formatter));
            return result;
        } catch (Exception e) {
            logger.error("记录日志发生异常", e);
            return point.proceed();
        }finally {
            String level= log.level();
            if("table".equals(level)){
                recordLogToTable(formatter,level);
            }
        }

    }

    @After("logAspect()")
    public void after() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            logger.info("本次请求结束,请求序列号是:{}", request.getAttribute("requestNo"));
        }
    }

    /**
     * 记录日志到表中
     * @param formatter
     * @param parameter
     */
    private void recordLogToTable(LogFormatter formatter,String... parameter){
        //todo
    }

}
