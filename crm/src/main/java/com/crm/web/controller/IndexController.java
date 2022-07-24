package com.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: com.crm.web.controller.IndexController
 * @author: lenovo
 * @date: 2022/7/13 13:24
 * @Description: 首页控制器
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }





}
