package com.inm.stores.DepartmentStores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages ={"com.inm.stores.repos"})
@ComponentScan("com.inm.stores.*")
@EntityScan("com.inm.stores.entities")
public class DepartmentStoresApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DepartmentStoresApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DepartmentStoresApplication.class, args);
	}
}
