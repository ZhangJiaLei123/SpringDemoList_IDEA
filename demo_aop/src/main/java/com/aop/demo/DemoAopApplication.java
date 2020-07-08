package com.aop.demo;

import com.aop.demo.aop.ControllerAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@ContextConfiguration(classes={ControllerAspect.class})//标出配置类，如果是配置文件，使用locations参数
public class DemoAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
		System.out.println("加载完成");
	}

}
