package com.akshat.hotel;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/lil");
		dataSource.setUsername("root");
		dataSource.setPassword("root#12345");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource();
	}
}
