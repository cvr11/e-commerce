package com.ecommerce.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author rvc41
 *	@Configuration to enable Java-based configuration
 *	- This annotation marks a class as a Configuration class for Java-based configuration. 
 *	- This is particularly important if you favor Java-based configuration over XML configuration
 * @Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime. 
 *	- This is called Spring Java Config feature (using @Configuration annotation)
 */
@Primary
@Configuration
public class MySqlConfig {

	/**
	 * This is for console logs
	 */
	private static final Logger logger = LoggerFactory.getLogger(MySqlConfig.class);
	
	@Value("${spring.datasource.url}")
	private String talenUrl;

	@Value("${spring.datasource.username}")
	private String talenUsername;

	@Value("${spring.datasource.password}")
	private String talenPwd;

	@Value("${spring.datasource.driverClassName}")
	private String talenDriverClassName;
	
	@Bean
	@Qualifier("talen")
	public JdbcTemplate talenJdbcTemplate() {
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getHikariDataSourceForTalen());
		return jdbcTemplate;
	}

	@Bean
	public HikariDataSource getHikariDataSourceForTalen() {

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(talenDriverClassName);
		hikariConfig.setUsername(talenUsername);
		hikariConfig.setPassword(talenPwd);
		hikariConfig.setJdbcUrl(talenUrl);

		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

		if (!hikariDataSource.isClosed()) {
			logger.info("------> MySql DataBase connection with TALEN successfull. URL {}", hikariDataSource.getJdbcUrl());
		}
		return hikariDataSource;
	}
}
