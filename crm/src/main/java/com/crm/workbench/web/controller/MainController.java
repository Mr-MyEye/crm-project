package com.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: com.crm.workbench.web.controller.MainController
 * @author: lenovo
 * @date: 2022/7/21 13:22
 * @Description: 该类的功能描述
 */

@Controller
@RequestMapping(value = "/workbench/main")
public class MainController {

    @RequestMapping("/index.do")
    public String index(){
        return "workbench/main/index";
    }

}
