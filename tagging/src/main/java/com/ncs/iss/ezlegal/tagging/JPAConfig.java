package com.ncs.iss.ezlegal.tagging;

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
@ComponentScan("com.ncs.iss.ezlegal.tagging")
@EntityScan({ "com.ncs.iss.ezlegal.tagging.common.model", "com.ncs.iss.ezlegal.tagging.forum.model", "com.ncs.iss.ezlegal.tagging.master.model", "com.ncs.iss.ezlegal.tagging.user.model" })
@EnableJpaRepositories(basePackages = { "com.ncs.iss.ezlegal.tagging.common.repository", "com.ncs.iss.ezlegal.tagging.forum.repository", "com.ncs.iss.ezlegal.tagging.master.repository", "com.ncs.iss.ezlegal.tagging.user.repository" })
@EnableJpaAuditing
public class JPAConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
