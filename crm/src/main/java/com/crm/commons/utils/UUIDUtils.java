package com.crm.commons.utils;

import java.util.UUID;

/**
 * @ClassName: com.crm.commons.utils.UUIDUtils
 * @author: lenovo
 * @date: 2022/7/22 15:43
 * @Description: 该类的功能描述
 */

public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void test(){
        System.out.println("123");
    }

}
