package com.crm.workbench.service.impl;

import com.crm.workbench.bean.Activity;
import com.crm.workbench.mapper.ActivityMapper;
import com.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: com.crm.workbench.service.impl.ActiveServiceImpl
 * @author: lenovo
 * @date: 2022/7/22 14:32
 * @Description: 该类的功能描述
 */

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insert(Activity row) {
        return activityMapper.insert(row);
    }
}
