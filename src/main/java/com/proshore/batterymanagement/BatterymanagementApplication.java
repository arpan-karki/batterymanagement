package com.proshore.batterymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BatterymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatterymanagementApplication.class, args);
	}

}
