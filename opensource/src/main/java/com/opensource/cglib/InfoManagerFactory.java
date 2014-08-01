package com.opensource.cglib;

import net.sf.cglib.proxy.Enhancer;

public class InfoManagerFactory {
	
	   /**
     * 创建不同权限要求的InfoManager
     * 
     * @param auth
     * @return
     */
    public static InfoManager getAuthInstance(AuthProxy auth) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallback(auth);
        return (InfoManager) enhancer.create();
    }

}
