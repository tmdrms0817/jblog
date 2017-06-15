package com.jx372.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public int checkID(String id) {
		return sqlSession.selectOne("user.checkID", id);
	}

	public int insert(UserVo vo) {
		return sqlSession.insert("user.insert", vo);
	}

	public UserVo getUser(String id , String password) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("password", password);
		return sqlSession.selectOne("user.getUser", map);
	}
}
