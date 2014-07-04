package org.mybatis.example;

import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import com.opensource.entity.Blog;
import com.opensource.entity.UserInfo;
import com.opensource.mapper.BlogMapper;
import com.opensource.mapper.UserMapperAnota;

public class Test {
	 private static SqlSessionFactory sqlSessionFactory;
	    private static Reader reader; 

	    static{
	        try{
	            reader    = Resources.getResourceAsReader("mybatis-config.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	            sqlSessionFactory.getConfiguration().addMapper(UserMapperAnota.class);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

	    public static SqlSessionFactory getSession(){
	        return sqlSessionFactory;
	    }
	    
	    public static void main(String[] args) {
	        SqlSession session = sqlSessionFactory.openSession();
	        try {
	        	UserMapperAnota ua =   	session.getMapper(UserMapperAnota.class);
	        	UserInfo user = ua.selectUser(1);
	        	// UserInfo user = (UserInfo) session.selectOne("org.mybatis.example.UserInfo.selectUserByID", 1);
			        System.out.println(user.getName());
			        System.out.println(user.getIdcard());
	        } finally {
	            session.close();
	        }
	    }
	    @org.junit.Test
	    public void testXmlMybatis(){
	   /* 	   SqlSession session = sqlSessionFactory.openSession();
	        try {
	        	Blog blog = 	session.selectOne("BlogMapper.findActiveBlogWithTitleLike", 1);
			    System.out.println(ToStringBuilder.reflectionToString(blog));
	        }catch(Exception e){
	        	e.printStackTrace();
	        } finally {
	        session.close();
	        }*/
	    }
	    @org.junit.Test
	    public void testXmlMybatis2(){
	    	   SqlSession session = sqlSessionFactory.openSession();
	        try {
	        	BlogMapper mapper = session.getMapper(BlogMapper.class);
	        	Blog blog = mapper.selectBlog(1);
			    System.out.println(ToStringBuilder.reflectionToString(blog));
	        }catch(Exception e){
	        	e.printStackTrace();
	        } finally {
	           session.close();
	        }
	    }
	    @org.junit.Test
	    public void testTransaction(){
	       final SqlSession session = sqlSessionFactory.openSession(TransactionIsolationLevel.READ_UNCOMMITTED);
	        try {
	        	session.clearCache();
	        	BlogMapper mapper = session.getMapper(BlogMapper.class);
	        	Blog blog = mapper.selectBlog(1);
	        	System.out.println(ToStringBuilder.reflectionToString(blog));
	        	session.clearCache();
	        	Thread.sleep(8000);
	        	BlogMapper mapper2 = session.getMapper(BlogMapper.class);
	        	Blog blog2 = mapper2.selectBlog(1);
			    System.out.println(ToStringBuilder.reflectionToString(blog2));
			    session.commit();
	        }catch(Exception e){
	        	e.printStackTrace();
	        } finally {
	           session.close();
	        }
	    }
	    @org.junit.Test
	    public void testReflector(){
	    	UserInfo.class.getDeclaredConstructors();
	    	MetaClass mc = MetaClass.forClass(UserInfo.class);
	    	Invoker invoker = mc.getSetInvoker("name");
	    	UserInfo ui = new UserInfo();
	    	try {
				invoker.invoke(ui, new String[]{"张"});
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String[] mg = mc.getGetterNames();
	    	System.out.println(ui.toString());
	    	for(String m:mg){
	    		System.out.println(m);
	    	}
	    }
}
