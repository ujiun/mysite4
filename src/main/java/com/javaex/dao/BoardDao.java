package com.javaex.dao;

import java.util.List;

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
	
	//list
	public List<BoardVo> getList() {
		System.out.println("BoardDao>getList()");
		
		List<BoardVo> bList = sqlSession.selectList("board.selectList");
		
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
