package com.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: com.crm.workbench.web.controller.WorkbenchIndexController
 * @author: lenovo
 * @date: 2022/7/14 18:16
 * @Description: 该类的功能描述
 */

@Controller
@RequestMapping("/workbench")
public class WorkbenchIndexController {

    @RequestMapping("/index.do")
    public String index(){
        return "workbench/index";
    }


}
