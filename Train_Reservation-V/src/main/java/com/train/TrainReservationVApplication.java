package com.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages="com.train.model")
//@EnableJpaRepositories(basePackages = "com.train.Repository")
public class TrainReservationVApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainReservationVApplication.class, args);
	}

}
