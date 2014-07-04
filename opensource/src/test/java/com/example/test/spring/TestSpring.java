package com.example.test.spring;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensource.entity.Blog;
import com.opensource.entity.UserInfo;
import com.opensource.mapper.BlogMapper;
import com.opensource.service.BlogService;
import com.opensource.service.api.UserApi;

public class TestSpring {
	private static   ApplicationContext ac;
	static{
		System.setProperty("spring.profiles.active", "production");
       ac = new  ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static void main(String[] args) {
		SqlSessionFactory  sessionFactory = 	(SqlSessionFactory )ac.getBean("sqlSessionFactory");
		BlogMapper  blogMapper = 	(BlogMapper )ac.getBean(BlogMapper.class);
		try {
			SqlSession session = sessionFactory.openSession();
			BlogMapper mapper = session.getMapper(BlogMapper.class);
//        	Blog blog = mapper.selectBlog(1);
  //      	Blog blog = 	session.selectOne("BlogMapper.selectBlog", 1);
        	Blog blog =  blogMapper.selectBlog(1);
		    System.out.println(ToStringBuilder.reflectionToString(blog));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testDao(){
		BlogService bd = (BlogService)ac.getBean("blogService");
		Blog blog = bd.getBlog(1);
		UserInfo ui = bd.getUser(1);
	    System.out.println(ToStringBuilder.reflectionToString(blog));
	    System.out.println(ToStringBuilder.reflectionToString(ui));
	}
	@Test
	public void testAnnotation(){
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		CustomerBo customer = (CustomerBo) context.getBean("customer");
		customer.printMsg("Hello 1");
 
		SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
		scheduler.printMsg("Hello 2");
	}
	@Test
	public void testBean(){
		UserApi bd = (UserApi)ac.getBean(UserApi.class);
	    System.out.println(ToStringBuilder.reflectionToString(bd));
	}
}
