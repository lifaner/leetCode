package com.face.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.face.dubboserviceapi.service.DemoInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * Create by lifan.
 * Date: 2019/4/28.
 * Time: 15:00.
 */
@Service(interfaceClass = DemoInterface.class)
@Controller
public class DemoServiceImpl implements DemoInterface {

    @Override
    public String callName(String name) {
        return "我是"+name;
    }

}
