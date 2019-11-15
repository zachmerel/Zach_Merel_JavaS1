package com.trilogyed.taskerconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TaskerConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskerConfigServiceApplication.class, args);
	}

}
