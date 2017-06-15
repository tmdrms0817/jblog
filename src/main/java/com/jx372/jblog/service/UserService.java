package com.jx372.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.jblog.exception.UserInsertException;
import com.jx372.jblog.repository.BlogDao;
import com.jx372.jblog.repository.CategoryDao;
import com.jx372.jblog.repository.UserDao;
import com.jx372.jblog.vo.BlogVo;
import com.jx372.jblog.vo.CategoryVo;
import com.jx372.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;

	public boolean checkID(String id) {
		return userDao.checkID(id) < 1;
	}
	
	public void join(UserVo vo) throws UserInsertException{
		
		boolean result = false;

		result = userDao.insert( vo ) == 1;
		if( result == false ) {
			throw new UserInsertException( "fail to save user's singup information" );
		}
		Long userNo = vo.getNo();
		
		//2. 블로그 생성
		BlogVo blogVo = new BlogVo();
		blogVo.setUserNo(userNo);
		blogVo.setTitle( vo.getName() + "의 blog 입니다." );
		blogVo.setLogo( "default-logo.jpg" );
		
		result = blogDao.insert( blogVo ) == 1;
		if( result == false ) {
			throw new UserInsertException( "fail to create user's blog" );
		}
		
		//3. 기본 카테고리 등록
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName( "미분류" );
		categoryVo.setUserNo(userNo);
		categoryVo.setDescription( "" );
		result = categoryDao.insert( categoryVo ) == 1;
		if( result == false ) {
			throw new UserInsertException( "fail to register default category of blog" );
		}
		
	}
	
	public UserVo getUser(String id , String password){
		return userDao.getUser(id,password);
	}
}
