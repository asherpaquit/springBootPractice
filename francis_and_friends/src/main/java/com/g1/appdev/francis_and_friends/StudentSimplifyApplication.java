package com.g1.appdev.francis_and_friends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSimplifyApplication {

	private static final Logger log = LoggerFactory.getLogger(StudentSimplifyApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(StudentSimplifyApplication.class, args);
	}

}
