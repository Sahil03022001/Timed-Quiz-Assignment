package com.Sahil.Springbootassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.Sahil.Springbootassignment")
public class SpringbootAssignmentQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAssignmentQuizApplication.class, args);
	}

}
