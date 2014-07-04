package com.opensource.entity;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class UserInfo{
	private int id;
	private String name;
	private int idcard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdcard() {
		return idcard;
	}
	public void setIdcard(int idcard) {
		this.idcard = idcard;
	}
	
	@Override
	public String toString() {
		return "id"+id+"name"+name+"idcard"+idcard;
	}

}
