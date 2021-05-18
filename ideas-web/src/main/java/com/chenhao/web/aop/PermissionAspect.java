package com.chenhao.web.aop;

import com.chenhao.common.constants.BusinessConstant;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.exception.SystemException;
import com.chenhao.web.annotions.Permission;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @description:权限控制切面
 * @author: chenhao
 * @date: 2021-1-7 15:28
 */
@Aspect
@Component
@Order(1)
public class PermissionAspect {

    private static final Logger logger= LoggerFactory.getLogger(PermissionAspect.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 打上permission注解的接口需要做登录态或者权限认证
     */
    @Pointcut("@annotation(com.chenhao.web.annotions.Permission)")
    public void permissionAop(){

    }

    /**
     * 环绕验证权限
     * @param point
     * @return
     */
    @Around("permissionAop()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature methodSignature= (MethodSignature) point.getSignature();
        Permission permission=methodSignature.getMethod().getAnnotation(Permission.class);
        if (permission.needLogin()){
            //验证登录态
        }
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if(sra==null){
            throw new SystemException();
        }
        String token=sra.getRequest().getHeader(BusinessConstant.TOKEN_IN_HEADER);
        if(StringUtils.isEmpty(token)) {
            throw new BusinessException(BusinessEnum.MISSING_HEADER.getCode(), BusinessEnum.MISSING_HEADER.getMsg());
        }
        String userId=stringRedisTemplate.opsForValue().get(BusinessConstant.TOKEN_FOR_USERID+token);
        if(StringUtils.isEmpty(userId)){
            throw new BusinessException(BusinessEnum.NO_PERMISSION.getCode(), BusinessEnum.NO_PERMISSION.getMsg());
        }
////        UserInfo userInfo=baseService.getUserInfoByUserId(userId);
//        if(userInfo==null){
//            throw new BusinessException(BusinessEnum.NO_PERMISSION.getCode(), BusinessEnum.NO_PERMISSION.getMsg());
//        }
////        CleanGovernmentPushRecord record=cleanGovernmentService.getRecordByUserId(userId);
//        if(record==null){
//            throw new BusinessException(BusinessEnum.NO_PERMISSION.getCode(), BusinessEnum.NO_PERMISSION.getMsg());
//        }
        return point.proceed();

    }
}
