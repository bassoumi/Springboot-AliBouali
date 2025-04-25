package com.bassoumi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(DemoApplication.class, args);
		myFirstService myFirstService = ctx.getBean(myFirstService.class);
		System.out.println(myFirstService.tellaStory());


	}



}
