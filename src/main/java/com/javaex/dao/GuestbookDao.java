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
	
	//방명록 저장(ajax)
	public int insertGuest(GuestbookVo vo) {
		System.out.println("GuestbookDao>insertGuest()");
		
		int count = sqlSession.insert("guestbook.insertSelectKey", vo);

		
		return count;
	}
	
	//방명록 저장후 등록한 데이터 가져오기(ajax)
	public GuestbookVo getGuest(int no) {
		System.out.println("GuestbookDao>getGuest()");
		
		sqlSession.selectOne("guestbook.getGuest", no);
		
		return sqlSession.selectOne("guestbook.getGuest", no);
	}
	
	//방명록 삭제
	public int guestDelete(GuestbookVo vo) {
		System.out.println("GuestbookDao>guestDelete()");
		
		return sqlSession.delete("guestbook.delete", vo);
	}
	
}
