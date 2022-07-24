package com.crm.workbench.web.controller;

import com.crm.commons.bean.ReturnObject;
import com.crm.commons.constants.Constants;
import com.crm.commons.utils.DateUtils;
import com.crm.commons.utils.UUIDUtils;
import com.crm.settings.bean.User;
import com.crm.settings.service.UserService;
import com.crm.workbench.bean.Activity;
import com.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: com.crm.workbench.web.controller.ActivityController
 * @author: lenovo
 * @date: 2022/7/21 16:08
 * @Description: 该类的功能描述
 */

@Controller
@RequestMapping(value = "/workbench/activity")
public class ActivityController {

    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @RequestMapping(value = "/index.do")
    public String index(
            HttpServletRequest request
    ) {
        List<User> users = userService.selectAllUsers();
        request.setAttribute("userList", users);
        return  "workbench/activity/index";
    }

    @RequestMapping("/saveCreateActivity")
    public @ResponseBody Object saveCreateActivity(
            Activity activity,
            HttpSession session
    ){
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formateDateTime(new Date()));
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        activity.setCreateBy(user.getId());
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityService.insert(activity);
            if (ret > 0 ){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                return returnObject;
            }else{
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_ERROR);
                returnObject.setMessage("系统忙....");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_ERROR);
            returnObject.setMessage("系统忙....");
        }
        return returnObject;
    }







}

