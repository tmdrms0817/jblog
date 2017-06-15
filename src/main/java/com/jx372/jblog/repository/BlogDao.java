package com.jx372.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo getBlog(String userID){
		return sqlSession.selectOne("blog.getBlog",userID);
	}
	
	public int insert(BlogVo vo){
		return sqlSession.insert("blog.insert", vo);
	}
}
