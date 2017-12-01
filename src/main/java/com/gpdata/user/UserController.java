package com.gpdata.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by liuyutong on 2017/12/1.
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String getUser(Map<String, Object> map) {
        map.put("description", "这是一个测试哟！");
        return "user";
    }
}
