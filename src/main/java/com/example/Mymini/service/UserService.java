package com.example.Mymini.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Mymini.model.UserDTO;

@Repository
@Service
public class UserService {
	
	private final String NAMESPACE = "mapper.UserMapper";
	@Autowired
	// mybatis에서 지원하는sql연결문
	private SqlSession sqlSession;
	public void register(UserDTO u) {
		sqlSession.insert(NAMESPACE + ".register", u);
	}
	public UserDTO auth(UserDTO u) {
		return sqlSession.selectOne(NAMESPACE + ".auth", u);
	}
	public UserDTO selectOne(int id) {
		return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
	}
}
