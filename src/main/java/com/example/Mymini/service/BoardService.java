package com.example.Mymini.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.Mymini.model.BoardDTO;

@Repository
@Service
public class BoardService {
	private final String NAMESPACE = "mapper.BoardMapper";
	@Autowired
	// mybatis에서 지원하는sql연결문
	private SqlSession sqlSession;
	private final int PAGE_SIZE = 15;

	public List<BoardDTO> selectAll(int pageNo, int categoryId) {
		HashMap<String, Integer> map = new HashMap<>();
		int startNum = (pageNo - 1) * PAGE_SIZE;
		map.put("startNum", startNum);
		map.put("PAGE_SIZE", PAGE_SIZE);
		map.put("categoryId", categoryId);
		System.out.println(map);
		return sqlSession.selectList(NAMESPACE + ".selectAll", map);
	}

	public void insert(BoardDTO b) {
		sqlSession.insert(NAMESPACE + ".insert", b);
	}

	public void update(BoardDTO b) {
		sqlSession.update(NAMESPACE + ".update", b);
	}

	public void delete(int id) {
		sqlSession.delete(NAMESPACE + ".delete", id);
	}

	public BoardDTO auth(BoardDTO u) {
		return sqlSession.selectOne(NAMESPACE + ".auth", u);
	}

	public int selectLastPage(int categoryId) {
		int total = sqlSession.selectOne(NAMESPACE + ".count", categoryId);
		if (total % PAGE_SIZE == 0) {
			return total / PAGE_SIZE;
		} else {
			return (total / PAGE_SIZE) + 1;
		}
	}
	public BoardDTO selectOne(int id) {
		return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
	}
}
