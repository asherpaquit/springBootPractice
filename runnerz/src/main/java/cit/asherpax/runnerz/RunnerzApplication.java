package cit.asherpax.runnerz;

import cit.asherpax.runnerz.run.Location;
import cit.asherpax.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// @SpringBootApplication is a convenience annotation that adds all the following:
// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the cit.asherpax.runnerz package.
@SpringBootApplication
public class RunnerzApplication {

	// Logger instance for logging information, warnings, errors, etc.
	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class,args);
	}

	// @Bean annotation indicates that a method produces a bean to be managed by the Spring container.
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1,"First Run", LocalDateTime.now(),LocalDateTime.now().plus(200, ChronoUnit.MINUTES),5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}

}
