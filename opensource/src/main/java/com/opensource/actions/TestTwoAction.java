package com.opensource.actions;
import org.apache.struts2.convention.annotation.Action;


public class TestTwoAction   { 

	@Action("test")
      public String go(){
    	  return "success";
      }
}
