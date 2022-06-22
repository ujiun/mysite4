package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	
	//생성자
	//메소드-gs
	//메소드-일반
	
	//전체리스트 가져오기
	public List<GuestbookVo> getList() {
		System.out.println("GuestbookDao>getList()");
		return sqlSession.selectList("guestbook.selectList");
	}
	
	//등록
	public int add(GuestbookVo vo) {
		System.out.println("GuestbookDao>add()");
		
		int count = sqlSession.insert("guestbook.guestInsert", vo);
		return count;
		
	}
	
	//삭제
	public int delete(GuestbookVo vo) {
		System.out.println("GuestbookDao>delete()");
		
		int count = sqlSession.delete("guestbook.guestDelete", vo);
		
		return count;
	}
}
