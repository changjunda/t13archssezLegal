package com.ncs.iss.ezlegal.forum;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ncs.iss.ezlegal.forum")
@EntityScan({ "com.ncs.iss.ezlegal.forum.model" })
@EnableJpaRepositories(basePackages = { "com.ncs.iss.ezlegal.forum.repository" })
@EnableJpaAuditing
public class JPAConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
