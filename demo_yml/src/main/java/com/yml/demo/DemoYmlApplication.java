package com.yml.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoYmlApplication.class, args);
		System.out.println("启动完成");
	}

}
