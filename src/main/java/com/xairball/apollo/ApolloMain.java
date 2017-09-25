package com.xairball.apollo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.xairball.apollo.mapper")
public class ApolloMain extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApolloMain.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApolloMain.class, args);
	}
}
