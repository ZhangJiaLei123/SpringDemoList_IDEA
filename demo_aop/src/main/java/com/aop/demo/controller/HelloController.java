package com.aop.demo.controller;

import com.aop.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by PhychoLee on 2016/10/13.
 * Description:
 */
@RestController
public class HelloController {

    // 查询uid:000000 http://localhost:8080/
    @RequestMapping("/")
    public User getUser(){
        User user = new User();

        return user;
    }

}
