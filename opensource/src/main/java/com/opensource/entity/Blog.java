package com.opensource.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("Blog")
public class Blog implements Serializable{
	private static final long serialVersionUID = -6968511422025224939L;
	private Integer id;
      private String state;
      private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
      
}
