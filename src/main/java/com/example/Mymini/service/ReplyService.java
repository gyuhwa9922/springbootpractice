package com.example.Mymini.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Mymini.model.BoardDTO;
import com.example.Mymini.model.ReplyDTO;

@Repository
@Service
public class ReplyService {
	private final String NAMESPACE = "mapper.ReplyMapper";
	@Autowired
	// mybatis에서 지원하는sql연결문
	private SqlSession sqlSession;
	private final int PAGE_SIZE = 15;

	public List<ReplyDTO> selectAll(int boardId) {
		HashMap<String, Integer> map = new HashMap<>();
		int startNum = (boardId - 1) * PAGE_SIZE;
		map.put("boardId", boardId);
//		map.put("startNum", startNum);
//		map.put("PAGE_SIZE", PAGE_SIZE);
		return sqlSession.selectList(NAMESPACE + ".selectAll", map);
	}

	public void insert(ReplyDTO r) {
		sqlSession.insert(NAMESPACE + ".insert", r);
	}

	public void update(BoardDTO b) {
		sqlSession.update(NAMESPACE + ".update", b);
	}

	public void delete(int id) {
		sqlSession.delete(NAMESPACE + ".delete", id);
	}
}
