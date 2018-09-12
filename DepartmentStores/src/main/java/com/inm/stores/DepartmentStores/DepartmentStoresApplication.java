package com.inm.stores.DepartmentStores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inm.stores.entities.FileStorageProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages ={"com.inm.stores.repos"})
@EnableConfigurationProperties({FileStorageProperties.class})
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
