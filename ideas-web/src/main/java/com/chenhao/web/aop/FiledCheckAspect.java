package com.chenhao.web.aop;

import com.chenhao.common.constants.BusinessConstant;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dto.annotations.NotNull;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.FieldSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-6-9 14:23
 */
@Component
@Aspect
@Order(4)
public class FiledCheckAspect {
    private static final Logger logger= LoggerFactory.getLogger(FiledCheckAspect.class);

    /**
     * 用于校验对应字段是否可以为空的aop
     */
    @Pointcut("@annotation(com.chenhao.dto.annotations.NotNull)")
    public void FiledCheckAspect(){

    }


    /**
     * 环绕式进行参数校验
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("FiledCheckAspect()&&target(t)")
    public Object around(ProceedingJoinPoint point,Object t) throws Throwable{
        FieldSignature signature= (FieldSignature) point.getSignature();
        NotNull annotation = signature.getField().getAnnotation(NotNull.class);
        Integer minValue= annotation.minValue();
        String name = signature.getName();
        Field field=signature.getField();
        field.setAccessible(true);
        Class<?> declaringClass = field.getDeclaringClass();
        //判断字符串是否为空
        if(declaringClass.equals(String.class)){
            if(StringUtils.isEmpty(field.get(t))){
                throw new BusinessException(BusinessEnum.MISSING_PARAMETER.getCode(),String.format(BusinessEnum.MISSING_PARAMETER.getMsg(),name));
            }
        }
        //判断列表什么的是否为空
        if(declaringClass.equals(Collection.class)){
            if(CollectionUtils.isEmpty((Collection<?>) field.get(t))){
                throw new BusinessException(BusinessEnum.MISSING_PARAMETER.getCode(),String.format(BusinessEnum.MISSING_PARAMETER.getMsg(),name));
            }
        }
        if(declaringClass.equals(Map.class)){
            Map o = (Map)field.get(t);
            if(o==null||o.size()== BusinessConstant.EMPTY){
                throw new BusinessException(BusinessEnum.MISSING_PARAMETER.getCode(),String.format(BusinessEnum.MISSING_PARAMETER.getMsg(),name));
            }
        }
        if(declaringClass.equals(Integer.class)||declaringClass.equals(int.class)){
            Integer o = (Integer) field.get(t);
            if(o==null){
                throw new BusinessException(BusinessEnum.MISSING_PARAMETER.getCode(),String.format(BusinessEnum.MISSING_PARAMETER.getMsg(),name));
            }
            if(o<minValue){
                throw new BusinessException(BusinessEnum.MISSING_MIN_VALUE.getCode(),String.format(BusinessEnum.MISSING_MIN_VALUE.getMsg(),minValue));
            }
        }

        if(declaringClass.equals(float.class)||declaringClass.equals(Float.class)){
            Float o = (Float) field.get(t);
            if(o==null){
                throw new BusinessException(BusinessEnum.MISSING_PARAMETER.getCode(),String.format(BusinessEnum.MISSING_PARAMETER.getMsg(),name));
            }
            if(o<minValue){
                throw new BusinessException(BusinessEnum.MISSING_MIN_VALUE.getCode(),String.format(BusinessEnum.MISSING_MIN_VALUE.getMsg(),minValue));
            }
        }

        if(declaringClass.equals(double.class)||declaringClass.equals(Double.class)){
            Double o = (Double) field.get(t);
            if(o==null){
                throw new BusinessException(BusinessEnum.MISSING_PARAMETER.getCode(),String.format(BusinessEnum.MISSING_PARAMETER.getMsg(),name));
            }
            if(o<minValue){
                throw new BusinessException(BusinessEnum.MISSING_MIN_VALUE.getCode(),String.format(BusinessEnum.MISSING_MIN_VALUE.getMsg(),minValue));
            }
        }
        return point.proceed();
    }

}
