package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
	final Logger logger = LoggerFactory.getLogger(MyApplication.class);
		SpringApplication.run(MyApplication.class, args);
		logger.info("In Main Function");
	}
//	
//   @Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("demo")).build();
//	}
	//swagger url=http://localhost:8011/swagger-ui/


}
