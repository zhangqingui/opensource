package com.opensource.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AuthProxy implements MethodInterceptor {
	
	private String name;
	
	public AuthProxy(String name) {
        this.name = name;
    }
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		if(!name.equals("zhang")){
			System.out.println(name+"不允许 进去");
			return null;
		}
		return proxy.invokeSuper(obj, args);
	}

}
