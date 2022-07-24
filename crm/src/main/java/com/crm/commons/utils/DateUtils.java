package com.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: com.crm.commons.utils.DateUtils
 * @author: lenovo
 * @date: 2022/7/14 22:23
 * @Description: Date数据处理
 */

public class DateUtils {

    public static String formateDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


}
