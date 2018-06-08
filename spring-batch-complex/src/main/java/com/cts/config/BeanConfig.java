package com.cts.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@Import(value = BatchConfig.class)
@PropertySource({"classpath:configuration.properties"})
public class BeanConfig extends BeanConfigurerSupport {

	@Autowired
	private Environment env;
	
	@Bean
	public JndiObjectFactoryBean dataSource() {
		JndiObjectFactoryBean jndiOFB = new JndiObjectFactoryBean();
		jndiOFB.setJndiName(env.getProperty("jdbc.url"));
		return jndiOFB;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate((DataSource) dataSource());
	}
}
