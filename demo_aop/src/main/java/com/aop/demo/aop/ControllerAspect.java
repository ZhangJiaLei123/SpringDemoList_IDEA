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
public class
ControllerAspect {
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

