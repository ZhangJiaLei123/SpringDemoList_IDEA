package com.yml.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


/// 数组样例
@Data
@Component
@ConfigurationProperties(prefix = "users") // 数据源注解
public class Users {

    private List<User> def; // 变量名要和yml中一样

    @Data
    public static class User{
        private int id;
        private String name;

    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + def +
                '}';
    }
}
