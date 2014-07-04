package com.example.test.spring;

import org.springframework.beans.factory.InitializingBean;

public class MyBeanInit implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.print("mybeaninit");
	}

}
