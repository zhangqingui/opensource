package com.jetty.run;

import java.io.File;
import java.util.Collections;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.Scanner;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyRunMain {
	public static void main(String[] args) throws Exception {
		/*     // 实例化一个容器
        Server server = new Server();
        // 配置一个connector
        Connector connector = new SelectChannelConnector();
        connector.setPort(Integer.getInteger("jetty.port",8080).intValue());
        server.setConnectors(new Connector[]
        { connector });

        String war = "/home/ben/test.war";
        String path = "/";

        System.err.println(war + " " + path);

        // 配置一个handler，这个handler会解析war包哦
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(path);
        webapp.setWar("E:/jrjwork/resteasyExample/resteasyExample/src/main/webapp");
        server.setHandler(webapp);
        server.setStopAtShutdown(true);
        // 启动容器，默认启动一个线程池。
        server.start();
        server.join();*/
		
		JettyRunMain.class.getClassLoader().getResource("").getPath();
		
        String webapp = System.getProperty("user.dir")+"/src/main/webapp";
		
        Server server = new Server(8070);
  
        WebAppContext context = new WebAppContext();
        context.setDescriptor(webapp + "/WEB-INF/web.xml");
       // context.setWar("E:/jrjstudy/opensource/opensource/target/opensource-0.0.1-SNAPSHOT.war");
       context.setResourceBase("E:/jrjstudy/opensource/opensource/src/main/webapp");
       context.setContextPath("/");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);
        Runtime.getRuntime().addShutdownHook(new Thread(){
        	@Override
        	public void run() {
        			System.out.println("stop");
        	}
        });
      
/*       Scanner _scanner = new Scanner();  
        _scanner.setScanDirs(Collections.singletonList(new File(JettyRunMain.class.getResource("/").getPath())));//设置要扫描的目录  
        _scanner.setScanInterval(1);//设置扫描间隔时间  
        _scanner.start();  */
        server.start();
        server.join();
 }
}
