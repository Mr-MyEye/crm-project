package com.crm.commons.bean;

/**
 * @ClassName: com.crm.commons.bean.ReturnObject
 * @author: lenovo
 * @date: 2022/7/14 17:09
 * @Description: 返回json数据
 */

public class ReturnObject {

    private String code;

    private String message;

    private Object retData;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }
}
