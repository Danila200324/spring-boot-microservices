package com.danven.Departmentmicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		info = @Info(
				title = "Department service",
				description = "Department service for microservice",
				version = "v1.0",
				contact = @Contact(
						name = "Danila",
						email = "danven2018@mail.ru"
				),
				license = @License(
						name = "Apache2.0"
				)
		)
)
@SpringBootApplication
public class DepartmentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMicroserviceApplication.class, args);
	}

}
