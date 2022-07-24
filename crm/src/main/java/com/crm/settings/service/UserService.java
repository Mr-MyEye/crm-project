package com.crm.settings.service;

import com.crm.settings.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: com.crm.settings.service.UserService
 * @author: lenovo
 * @date: 2022/7/14 13:36
 * @Description: 该类的功能描述
 */

public interface UserService {

    User selectUserByLoginActAndPwd(Map<String,Object> map);

    List<User> selectAllUsers();

}
