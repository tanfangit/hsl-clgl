package com.hsl.clgl;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static final Logger logger = LoggerFactory.getLogger(App.class);
	 
	   
	    /**
	     * Main Start
	     */
	    public static void main(String[] args) {
	        SpringApplication.run(App.class, args);
	        logger.info("============= SpringBoot Start Success =============");
	    }
	 
     
}
