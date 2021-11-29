package com.chenhao.dto.validate;

import com.chenhao.dto.annotations.NotNull;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @description: 参数校验类
 * @author: chenhao
 * @date: 2021-11-26 16:10
 */
public class ValidateUtils {
    private static final Integer EMPTY=0;
    private static final String EMPTY_STRING="";
    private static final Integer MOBILE_LENGTH=11;
    private static final String MOBILE_REGEX="/^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$/";
    private static final String EMAIL_REGEX="";
    public static final String VALID="valid";
    /**
     * 获取对象的所有属性
     * @param clazz
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "deprecation" })
    public static List<Field> getAllDeclareFields(Class clazz) throws Exception {
        Assert.notNull(clazz,"the parameter [clazz]  can not be null");
        List<Field> result=new ArrayList<>();
        for(Class superClass=clazz;superClass!=Object.class;superClass=superClass.getSuperclass()){
            Field[] fields=superClass.getDeclaredFields();
            if(fields.length>EMPTY){
                result.addAll(Arrays.asList(fields));
            }
        }
        return result;
    }

    /**
     * 字段校验方法
     * @param object 需要校验的对象
     * @param paramsValue 待定用的参数map
     * @param ignoreNames 忽略不用校验的属性
     * @return
     * @throws Exception
     */
    public static String validate(Object object, Map<String,String> paramsValue,String[] ignoreNames) throws Exception{
        List<Field> fields=ValidateUtils.getAllDeclareFields(object.getClass());
        Map<String,String> tempMap=new HashMap<>(ignoreNames==null?4:ignoreNames.length);
        if(ignoreNames!=null&&ignoreNames.length>EMPTY){
            for (String var:ignoreNames){
                tempMap.put(var, EMPTY_STRING);
            }
        }
        for(Field field:fields){
            if(field.isAnnotationPresent(NotNull.class)){
                String fieldName= field.getName();
                if(tempMap.containsKey(fieldName)){
                    continue;
                }
                field.setAccessible(true);
                NotNull.Types fieldType=null;
                boolean isRequired=false;
                for(Annotation annotation:field.getAnnotations()){
                    if(annotation instanceof NotNull){
                        isRequired= ((NotNull) annotation).required();
                        fieldType=((NotNull) annotation).type();
                        if(!isRequired){
                            continue;
                        }
                        Object value=field.get(object);
                        if(Objects.isNull(value)){
                            return fieldName+" can't be null";
                        }
                        switch (fieldType){
                            case INT:
                                if((int)value<((NotNull) annotation).minValue()){
                                    return fieldName+" must greater than "+((NotNull) annotation).minValue();
                                }
                                if((int)value>((NotNull) annotation).maxValue()){
                                    return fieldName+" must less than "+((NotNull) annotation).minValue();
                                }
                                return VALID;
                            case Long:
                                if((long)value<((NotNull) annotation).minValue()){
                                    return fieldName+" must greater than "+((NotNull) annotation).minValue();
                                }
                                if((long)value>((NotNull) annotation).maxValue()){
                                    return fieldName+" must less than "+((NotNull) annotation).minValue();
                                }
                                return VALID;
                            case Double:
                                if((double)value<((NotNull) annotation).minValue()){
                                    return fieldName+" must greater than "+((NotNull) annotation).minValue();
                                }
                                if((double)value>((NotNull) annotation).maxValue()){
                                    return fieldName+" must less than "+((NotNull) annotation).minValue();
                                }
                                return VALID;
                            case Mobile:
                                 if(((String) value).length()!=MOBILE_LENGTH){
                                     return fieldName +" is invalid";
                                 }
                                if(!Pattern.matches(MOBILE_REGEX,(String)value)){
                                    return fieldName +" is invalid";
                                }
                                return VALID;
                            case Email:
                            case CHAR:
                            case Date:
                            case STRING:
                            case Boolean:
                            default:
                                return VALID;
                        }

                    }
                }
            }
        }
        //清缓存
        tempMap.clear();
        return VALID;

    }
}
