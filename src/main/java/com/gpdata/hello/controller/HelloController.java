package com.gpdata.hello.controller;

import com.gpdata.hello.dao.UserDao;
import com.gpdata.hello.entity.User;
import com.gpdata.hello.vo.BeanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by acer_liuyutong on 2017/5/10.
 */
@RestController
public class HelloController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/now")
    public String hehe() {
        return "现在时间：" + new Date();
    }

    @RequestMapping("/user")
    public BeanResult getOne(){
        List<User> all = userDao.findAll();
        return BeanResult.success(all);
    }
}
