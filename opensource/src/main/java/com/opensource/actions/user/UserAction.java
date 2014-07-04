package com.opensource.actions.user;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;


public class UserAction   extends ActionSupport { 
      /**
	 * 
	 */
	private static final long serialVersionUID = -5846750405518886389L;
 
	  @Action("info")
      public String go(){
		System.out.print("-----------");
    	  return "success";
      }
} 
