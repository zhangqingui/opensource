package com.opensource.actions;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensource.entity.Blog;
import com.opensource.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class TestAction   extends ActionSupport{ 
      /**
	 * 
	 */
	private String cookielist;
	private String xx;
	private static final long serialVersionUID = -5846750405518886389L;
	@Autowired
	private BlogService blogService;
	@Action("go")
    public String go(){
	       Blog blog = blogService.getBlog(1);
		   ServletActionContext.getRequest().setAttribute("blog",blog);
		   String name = "zhangqinghui";
		   System.out.println("my name isx  "+ name.charAt(5));
		   System.out.print("----eeeeecookielisdddt----"+cookielist);
		   return "";
      } 
	@Action("sese")
    public String sese(){
		System.out.print("-----------");
		return "";
    }
	public String getCookielist() {
		return cookielist;
	}
	public void setCookielist(String cookielist) {
		this.cookielist = cookielist;
	}
	public String getXx() {
		return xx;
	}
	public void setXx(String xx) {
		this.xx = xx;
	}
	
}
