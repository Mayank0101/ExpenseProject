package com.homeexpense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class MyHomeExpensesV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeExpensesV1Application.class, args);
	}
}
