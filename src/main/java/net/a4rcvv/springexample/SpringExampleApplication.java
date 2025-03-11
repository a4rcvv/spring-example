package net.a4rcvv.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringExampleApplication {
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

}
