package com.crm.settings.web.controller;

import com.crm.commons.bean.ReturnObject;
import com.crm.commons.constants.Constants;
import com.crm.commons.utils.DateUtils;
import com.crm.settings.bean.User;
import com.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: com.crm.settings.web.controller.UserController
 * @author: lenovo
 * @date: 2022/7/14 13:44
 * @Description: 该类的功能描述
 */

@Controller
@RequestMapping("/settings/qx/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin.do")
    public String toLogin(){
        return "settings/qx/user/login";
    }

    @RequestMapping("/login.do")
    public @ResponseBody Object login(
            @RequestParam String loginAct,@RequestParam String loginPwd,
            @RequestParam String isRemPwd, HttpServletRequest request,
            HttpSession session, HttpServletResponse response
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        User user = userService.selectUserByLoginActAndPwd(map);
        ReturnObject returnObject = new ReturnObject();
        if (user == null){
            returnObject.setCode("0");
            returnObject.setMessage("用户名或密码错误");
        }else{
            String nowTime = DateUtils.formateDateTime(new Date());
            if (nowTime.compareTo(user.getExpireTime())>0){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_ERROR);
                returnObject.setMessage("账号已过期");
            }else if ("0".equals(user.getLockState())){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_ERROR);
                returnObject.setMessage("状态已锁定");
            }else if(!user.getAllowIps().contains(request.getRemoteAddr())){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_ERROR);
                returnObject.setMessage("ip锁定");
            }else {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                session.setAttribute(Constants.SESSION_USER, user);


                if(isRemPwd.equals("true")){
                    Cookie cookieLoginAct = new Cookie("loginAct", user.getLoginAct());
                    cookieLoginAct.setMaxAge(Constants.COOKIE_MAX_AGE);
                    response.addCookie(cookieLoginAct);

                    Cookie cookieLoginPwd = new Cookie("loginPwd", user.getLoginPwd());
                    cookieLoginPwd.setMaxAge(Constants.COOKIE_MAX_AGE);
                    response.addCookie(cookieLoginPwd);
                }else {
                    Cookie cookieLoginAct = new Cookie("loginAct", "0");
                    cookieLoginAct.setMaxAge(0);
                    Cookie cookieLoginPwd = new Cookie("loginPwd", "0");
                    cookieLoginPwd.setMaxAge(0);
                    response.addCookie(cookieLoginAct);
                    response.addCookie(cookieLoginPwd);
                }
            }
        }
        return returnObject;
    }

    @RequestMapping("/logout.do")
    public String loginOut(HttpSession session,HttpServletResponse response){
        Cookie cookieLoginAct = new Cookie("loginAct", "0");
        cookieLoginAct.setMaxAge(0);
        Cookie cookieLoginPwd = new Cookie("loginPwd", "0");
        cookieLoginPwd.setMaxAge(0);
        response.addCookie(cookieLoginAct);
        response.addCookie(cookieLoginPwd);

        session.invalidate();
        return "redirect:/";
    }

}
