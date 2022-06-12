package com.ibm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableAutoConfiguration
@Configuration
@ComponentScan({"com.ibm.*"})
@EnableWebMvc
@SpringBootApplication
public class IbmCrsG4SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmCrsG4SpringJdbcTemplateApplication.class, args);
	}

}
