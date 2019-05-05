package com.face.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.face.dubboserviceapi.service.DemoInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by lifan.
 * Date: 2019/4/28.
 * Time: 15:46.
 */
@Controller
@RequestMapping("/index")
public class DemoController {

    @Reference(check = false)
    private DemoInterface demoInterface;

    @RequestMapping
    @ResponseBody
    public String index(){
        return demoInterface.callName("justin");
    }
}
