package com.chenhao.web.aop;

import com.chenhao.common.constants.BusinessConstant;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.exception.SystemException;
import com.chenhao.common.utils.UrlParserUtil;
import com.chenhao.web.annotions.ApiPermission;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

/**
 * @description: api权限控制类，用于控制访问本系统的api权限
 * 权限控制的方式是在阿波罗配置中心添加appid 同时访问的时候header
 * 中要带MBUP-APP-ID
 * @author: chenhao
 * @date: 2021-2-26 9:44
 */
@Component
@Aspect
@Order(0)
public class ApiPermissionAspect {
    private static final Logger logger= LoggerFactory.getLogger(ApiPermissionAspect.class);

    /**
     * 通过apiPermission注解进行权限控制，未打上该注解不会去做权限控制
     */
    @Pointcut("@annotation(com.chenhao.web.annotions.ApiPermission)")
    public void ApiPermissionAspect(){

    }


    /**
     * 环绕验证权限
     * @param point
     * @return
     */
    @Around("ApiPermissionAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature methodSignature= (MethodSignature) point.getSignature();
        ApiPermission permission=methodSignature.getMethod().getAnnotation(ApiPermission.class);
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if(sra==null){
            throw new SystemException();
        }
        HttpServletRequest request = sra.getRequest();
        String appId=request.getHeader(BusinessConstant.API_PERMISSION_HEADER);
        String url= URLDecoder.decode(request.getRequestURL().toString(),"UTF-8");
        if(StringUtils.isEmpty(appId)){
            if(!url.contains("appId")){
                throw new BusinessException(BusinessEnum.NO_API_PERMISSION);
            }
            //不是通过http请求头的方式传递权限标识的话可以通过在url上面带参数?appId=xxxx;
            appId= UrlParserUtil.fromURL(url).getParameter("appId");
            if(StringUtils.isEmpty(appId)){
                //未带验证权限标识
                throw new BusinessException(BusinessEnum.NO_API_PERMISSION);
            }
        }
//        String[] appIds = ConfigService.getAppConfig().getArrayProperty(BusinessConstant.APPIDS_WITH_PERMISSION, BusinessConstant.DELIMITER, new String[]{});
//        List<String> appIdList= Arrays.asList(appIds);
//        if(!appIdList.contains(appId)){
//            //appId无权限访问此接口
//            logger.info("{}无访问该接口:{}的权限",appId,url);
//            throw new BusinessException(BusinessEnum.APP_ID_WITH_NO_PERMISSION);
//        }

        return point.proceed();

    }

}
