package ru.innopolis.stc31.appeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Application entry point
 */
@SpringBootApplication
@EntityScan(basePackages= {"ru.innopolis.stc31.appeal.model"})
public class AppealApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppealApplication.class, args);
	}

}
