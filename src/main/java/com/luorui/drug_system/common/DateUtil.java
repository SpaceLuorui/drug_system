package com.luorui.drug_system.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 罗锐
 * @date 2023/4/27
 */
public class DateUtil {
    /**
     * 把日期格式转换成年月日(yyyy-MM-dd)的字符串
     */
    public static String dateConvert(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
