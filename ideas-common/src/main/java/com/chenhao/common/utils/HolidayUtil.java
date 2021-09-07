package com.chenhao.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @description:校验是否是节假日
 * @author: chenhao
 * @date: 2021-7-6 13:01
 */
public class HolidayUtil {

    /**
     * 判断是否是工作日，包含是否需要补班的情况
     * @param date
     * @param holidaysWithoutWeekends
     * @param isBroker
     * @param extraWorkdays
     * @return
     */
    public static Boolean isWorkDay(String date, List<String>holidaysWithoutWeekends,Boolean isBroker,List<String> extraWorkdays) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        //防止平年和闰年问题
        format.setLenient(false);
        Date targetDate;
        try {
            targetDate = format.parse(date);
        }catch (Exception e){
            return false;
        }
        //判断是否是除周末外的法定节假日
        if(holidaysWithoutWeekends.contains(date)){
            return false;
        }
        //非券商公司需要周末补班
        if(!isBroker){
            //不是券商公司或者额外规定不补班的公司要有补班的时间日期
            if(extraWorkdays==null||extraWorkdays.isEmpty()){
                return false;
            }
            //存在于额外补班的日期中，所以是工作日
            if(extraWorkdays.contains(date)){
                return true;
            }
        }
       //判断是否是周末
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(targetDate);
        return !(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||
                calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY);
    }
}
