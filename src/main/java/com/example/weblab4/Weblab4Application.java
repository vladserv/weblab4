package com.example.weblab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableScheduling
public class Weblab4Application {
	public static void main(String[] args) {
		SpringApplication.run(Weblab4Application.class, args);
	}

}
