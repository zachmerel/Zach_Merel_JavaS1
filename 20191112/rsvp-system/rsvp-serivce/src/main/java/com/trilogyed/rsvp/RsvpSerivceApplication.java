package com.trilogyed.rsvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RsvpSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsvpSerivceApplication.class, args);
	}

}
