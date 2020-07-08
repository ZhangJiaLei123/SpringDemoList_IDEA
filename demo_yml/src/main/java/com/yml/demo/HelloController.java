package com.yml.demo;

import com.yml.demo.model.Users;
import com.yml.demo.model.WxMpProperties;
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
    // 方法1. 自动读取 resources下的application.yml 文件
    @Autowired
    private Environment env;
    // 方法2. 默认服务器访问端口
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private WxMpProperties wxMpProperties;

    @Autowired
    private Users users;


    public HelloController(Environment env) {
        this.env = env;
    }


    @RequestMapping("/")
    public WxMpProperties getdef(){
        System.out.println(wxMpProperties);
        return wxMpProperties;
    }

    @RequestMapping("/user")
    public Users getUser(){
        return users;
    }

}
