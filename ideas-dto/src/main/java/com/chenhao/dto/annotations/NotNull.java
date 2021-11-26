package com.chenhao.dto.annotations;

import java.lang.annotation.*;

/**
 * @description:字段备注
 * @author: chenhao
 * @date: 2021-6-9 14:21
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
    public enum Types{
        /**
         * int型数据
         */
        INT,
        /**
         * CHAR型数据
         */
        CHAR,
        /**
         * STRING型数据
         */
        STRING,
        /**
         * Boolean型数据
         */
        Boolean,
        /**
         * Date型数据
         */
        Date,
        /**
         * Double型数据
         */
        Double,
        /**
         * Long型数据
         */
        Long,
        /**
         * Mobile型数据
         */
        Mobile,
        /**
         * Email型数据
         */
        Email
    }
    /**
     * 需要判断是否为空的字段名
     * @return
     */
    int minValue() default 0;

    /**
     * 类型
     * @return
     */
    Types type() default Types.STRING;

    /**
     * 字段允许的最大值
     * @return
     */

    int maxValue() default Integer.MAX_VALUE;

    /**
     * 是否必须
     * @return
     */
    boolean required() default false;

    /**
     * 字段备注
     * @return
     */
    String notes() default "";

    /**
     * 字段默认值
     * @return
     */
    String defaultValue() default "";
}
