package com.example.test.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
		@Bean(name="customer")
		public CustomerBo customerBo(){
			return new CustomerBo();
		}
}
