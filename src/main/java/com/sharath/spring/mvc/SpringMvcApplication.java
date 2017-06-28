package com.sharath.spring.mvc;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SpringMvcApplication extends SpringBootServletInitializer{
	@Autowired
	private EntityManagerFactory entityManagerFactory;
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(SpringMvcApplication.class);
}
 
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}
//	
	@Bean
	public SessionFactory getSessionFactory() {
	    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
