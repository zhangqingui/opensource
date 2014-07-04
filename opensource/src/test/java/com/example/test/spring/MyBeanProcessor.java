package com.example.test.spring;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.opensource.service.api.HttpUrl;
import com.opensource.service.api.Myano;

public class MyBeanProcessor implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("------");
		 Class<?> cls = bean.getClass();  
		 if(cls.isAnnotationPresent(Myano.class)){
		      for (Method method: cls.getMethods()) {  
		            if (method.isAnnotationPresent(HttpUrl.class)) {  
		            	method.getAnnotation(HttpUrl.class).value();
		            }  
		        }  
		 }
	  
	        return bean;  
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

}
