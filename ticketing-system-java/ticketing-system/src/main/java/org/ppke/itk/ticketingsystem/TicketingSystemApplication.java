package org.ppke.itk.ticketingsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@OpenAPIDefinition
@SpringBootApplication
public class TicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingSystemApplication.class, args);
	}

	/*@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.ppke.itk.ticketingsystem")).build();
	}*/

}
