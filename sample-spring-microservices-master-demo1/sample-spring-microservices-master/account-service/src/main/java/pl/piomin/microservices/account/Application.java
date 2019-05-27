package pl.piomin.microservices.account;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableJSONDoc
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		 ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		 context.getBean(AccountService.class).initiateAccountData(); // <-- here
	}

}
