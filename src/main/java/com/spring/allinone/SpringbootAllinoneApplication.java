package com.spring.allinone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.spring.allinone.travel.model")
@EnableJpaRepositories("com.spring.allinone.travel.repository")
@SpringBootApplication(scanBasePackages={"com.spring.allinone"})
public class SpringbootAllinoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAllinoneApplication.class, args);
	}

}
