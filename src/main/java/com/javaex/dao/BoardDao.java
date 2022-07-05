package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	//메소드-gs
	//메소드-일반
	
	//list(일반)
	public List<BoardVo> getList4(int startRnum, int endRnum) {
		System.out.println("BoardDao>getList4()");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		List<BoardVo> bList = sqlSession.selectList("board.selectList4", map);
		
		return bList;
	}
	
	//전체글 갯수
	public int selectTotalCnt() {
		System.out.println("BoardDao>selectTotalCnt()");
		
		int totalCnt = sqlSession.selectOne("board.selectTotalCnt");
		
		
		return totalCnt;
	}
	
	
	
	
	//list
	public List<BoardVo> getList(String keyword) {
		System.out.println("BoardDao>getList()");
		System.out.println(keyword);
		List<BoardVo> bList = sqlSession.selectList("board.selectList", keyword);
		
		return bList;
	}

	
	//read
	public BoardVo getBoard(int no) {
		System.out.println("BoardDao>getboard()");
		
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", no);
		
		return boardVo;
	}
	
	//upHit
	public int upHit(int no) {
		System.out.println("BoardDao>upHit()");
		
		int count = sqlSession.update("board.upHit", no);
		
		return count;
	}
	
	//write
	public int add(BoardVo boardVo) {
		System.out.println("BoardDao>write()");
		
		int count = sqlSession.insert("board.add", boardVo);
		
		return count;
	}
	
	//delete
	public int delete(int no) {
		System.out.println("BoardDao>delete()");
		
		int count = sqlSession.delete("board.delete", no);
		
		return count;
	}
	
	//modify
	public int update(BoardVo boardVo) {
		System.out.println("BoardDao>update()");
		
		int count = sqlSession.update("board.update", boardVo);
		
		return count;
	}
	
	
}
