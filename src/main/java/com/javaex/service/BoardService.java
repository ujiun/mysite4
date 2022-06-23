package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	//필드
	@Autowired
	private BoardDao boardDao;
	
	
	//생성자
	//메소드-gs
	//메소드-일반
	
	//list
	public List<BoardVo> getList(String keyword) {
		System.out.println("BoardService>getList()");
		
		List<BoardVo> bList = boardDao.getList(keyword);
		
		return bList;
	}
	
	
	//read + upHit
	public BoardVo getBoard(int no) {
		System.out.println("BoardService>getboard()");
		
		boardDao.upHit(no);
		BoardVo boardVo = boardDao.getBoard(no);
		
		return boardVo;
	}
	
	//modifyForm
	public BoardVo getBoard2(int no) {
		System.out.println("BoardService>getboard2()");
		
		BoardVo boardVo = boardDao.getBoard(no);
		
		return boardVo;
	}

	
	//write
	public int write(BoardVo boardVo) {
		System.out.println("BoardService>write()");
		
		int count = boardDao.add(boardVo);
		
		return count;
	}
	
	//delete
	public int delete(int no) {
		System.out.println("BoardSErvice>delete");
		
		int count = boardDao.delete(no);
		
		return count;
	}
	
	//modify
	public int modify(BoardVo boardVo) {
		System.out.println("BoardSErvice>modify");
		
		int count = boardDao.update(boardVo);
		
		return count;
	}
	
	
}
