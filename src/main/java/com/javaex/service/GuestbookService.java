package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	// 필드
	@Autowired
	private GuestbookDao guestbookDao;
	// 생성자

	// 메소드-gs

	// 메소드-일반

	// 리스트
	public List<GuestbookVo> getList() {
		System.out.println("GuestbookService>getList()");
		List<GuestbookVo> gList = guestbookDao.getList();

		return gList;
	}

	// 등록
	public int add(GuestbookVo vo) {
		System.out.println("GuestbookService>add()");
		int count = guestbookDao.add(vo);

		return count;
	}

	// 삭제
	public int delete(GuestbookVo vo) {
		System.out.println("GuestbookService>delete()");
		int count = guestbookDao.delete(vo);
		
		return count;
	}
	
	//방명록 저장(ajax)
	public GuestbookVo addGuest(GuestbookVo vo) {
		System.out.println("GuestbookService>addGuest()");
		
		//저장
		int count = guestbookDao.insertGuest(vo);
		
		int no = vo.getNo();
		
		
		//방금 저장한 1개의 데이터를 가져온다
		GuestbookVo gvo = guestbookDao.getGuest(no);
		
		System.out.println(gvo);
		return gvo;
	}
	
}
