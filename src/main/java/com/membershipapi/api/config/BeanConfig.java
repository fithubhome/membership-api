package com.membershipapi.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "com.membershipapi.api.repository")
public class BeanConfig {

}
