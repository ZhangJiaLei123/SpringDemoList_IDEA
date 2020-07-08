
## Demo 说明
* 最简spring AOP demo
* 包名 : com.aop.demo
* 注册切面类 : com.aop.demo.aop
* controller类 : com.aop.demo.controller
* 数据类 :  com.aop.demo.model
* 测试类 : com.aop.demo.DemoAopApplication

* 访问测试 :  http://localhost:8080/

### 1 导入依赖包

```

<dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>5.2.6.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.6.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>5.2.6.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.2.6.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
</dependencies>


```

### 2. 编写配置类和切面类(这里我放一起) 

 > 包名不能错

```
package com.aop.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect // 注册切面
@Configuration// 注册配置类
@EnableAspectJAutoProxy// 开启AOP
@ComponentScan("com.aop.demo")// 注册扫描包
public class ControllerAspect {
    // 前置通知:
    @Before(value = "ControllerAspect.pointcut1()")
    public void before() {
        System.out.println("前置通知===========");
    }

    // 后置通知:
    @After(value = "ControllerAspect.pointcut2()")
    public void after() {
        System.out.println("后置通知============");
    }

    // 环绕通知:
    @Around(value = "ControllerAspect.pointcut3()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知==========");
        Object obj = joinPoint.proceed();
        System.out.println("环绕后通知==========");
        return obj;
    }

    // 返回通知
    @AfterReturning(value = "ControllerAspect.pointcut4()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("返回通知===========" + result);
    }

    // 异常抛出通知:
    @AfterThrowing(value = "ControllerAspect.pointcut4()", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("异常抛出通知=========" + e.getMessage());
    }


    // 切入点注解：
    @Pointcut(value = "execution(* com.aop.demo.controller.HelloController.getUser(..))")
    private void pointcut1() {
    }

    @Pointcut(value = "execution(* com.aop.demo.controller.HelloController.getUser(..))")
    private void pointcut2() {
    }

    @Pointcut(value = "execution(* com.aop.demo.controller.HelloController.getUser(..))")
    private void pointcut3() {
    }

    @Pointcut(value = "execution(* com.aop.demo.controller.HelloController.getUser(..))")
    private void pointcut4() {
    }

}

```

### 3. 被加强类 

```
package com.aop.demo.controller;

import com.aop.demo.model.User;
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


```

### 4. 测试类 

```

import com.aop.demo.aop.ControllerAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication // 启动项注解
@ContextConfiguration(classes={UserServiceAspect.class})//标出配置类，如果是配置文件，使用locations参数
public class DemoAopApplication {

	public static void main(String[] args) {
		SpringApplication.
				run(DemoAopApplication.class, args);
	}

}


```


