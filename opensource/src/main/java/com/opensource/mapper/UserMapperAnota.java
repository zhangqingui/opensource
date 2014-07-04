package com.opensource.mapper;

import org.apache.ibatis.annotations.Select;

import com.opensource.entity.UserInfo;
@IbatisMapper
public interface UserMapperAnota {
	 @Select("SELECT * FROM user WHERE id = #{id}")
	public  UserInfo selectUser(int id);
}
