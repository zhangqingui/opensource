package com.opensource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensource.entity.Blog;
import com.opensource.entity.UserInfo;
import com.opensource.mapper.BlogMapper;
import com.opensource.mapper.UserMapperAnota;

@Service
public class BlogService {

	@Autowired
	private BlogMapper bm;

	@Autowired
	private UserMapperAnota uma;

	public Blog getBlog(Integer id) {
		return bm.selectBlog(id);
	}

	public UserInfo getUser(Integer id) {
		return uma.selectUser(id);
	}
}
