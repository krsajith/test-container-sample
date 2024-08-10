package com.taomish;

import com.taomish.service.Customer;
import com.taomish.service.CustomerService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.taomish"})
@RestController
@EnableJpaRepositories(basePackages = { "com.taomish"})
@EntityScan(basePackages = { "com.taomish"})
public class DemoApplication {

	private final CustomerService myService;

	public DemoApplication(CustomerService myService) {
		this.myService = myService;
	}

	@GetMapping("/")
	public Optional<Customer> home() {
		return myService.createCustomer();
	}

	@Getter
    private static ConfigurableApplicationContext applicationContext;
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

//	public static void main(String[] args) {
//		try {
//			applicationContext = new SpringApplicationBuilder(ApplicationOneApplication.class, ApplicationTwoApplication.class)
//					.run(args);
//		} catch (Exception e) {
//			logger.error("failed to run main",e);
//		}
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
