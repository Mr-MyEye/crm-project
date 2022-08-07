package com.crm.workbench.service;

import com.crm.workbench.bean.Activity;

/**
 * @ClassName: com.crm.workbench.service.ActiveService
 * @author: lenovo
 * @date: 2022/7/22 14:20
 * @Description: 该类的功能描述
 */

public interface ActivityService {

    int insert(Activity row);

    int saveCreateActivity(Activity activity);

}
