package com.opensource.mapper;

import com.opensource.entity.Blog;
@IbatisMapper
public interface BlogMapper {
	public	Blog selectBlog(Integer id);
}
