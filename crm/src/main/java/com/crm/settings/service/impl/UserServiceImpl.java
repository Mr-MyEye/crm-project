package com.crm.settings.service.impl;

import com.crm.settings.bean.User;
import com.crm.settings.mapper.UserMapper;
import com.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: com.crm.settings.service.impl.UserServiceImpl
 * @author: lenovo
 * @date: 2022/7/14 13:37
 * @Description: 该类的功能描述
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByLoginActAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoginActAndPwd(map);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }
}
