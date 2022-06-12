package com.ibm.application;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan({"com.ibm.*"})
@EnableWebMvc
public class IbmCrsG4SpringRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(IbmCrsG4SpringRestApplication.class, args);
	}	
	
}
