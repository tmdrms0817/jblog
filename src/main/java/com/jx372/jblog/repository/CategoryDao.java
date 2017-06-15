package com.jx372.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	public SqlSession sqlSession;
	
	public int insert(CategoryVo vo){
		return sqlSession.insert("category.insert", vo);
	}

}
