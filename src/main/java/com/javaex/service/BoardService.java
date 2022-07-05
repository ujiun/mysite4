package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//list(일반)
	public Map<String, Object> getList4(int crtPage) {
		System.out.println("BoardService>getList4()");
		
		/////////////////리스트가져오기
		
		
		
		//페이지당 글갯수
		int listCnt = 10;
		
		//전체페이지
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		
		
		//시작글번호
		int startRnum = (crtPage - 1)*listCnt + 1;
		
		//끝글번호
		int endRnum = (startRnum + listCnt) - 1;
		
		List<BoardVo> bList = boardDao.getList4(startRnum, endRnum);
		
		/////////////////////////////////////////////////
		//페이징 계산
		/////////////////////////////////////////////////
		
		//전체글갯수
		int totalCnt = boardDao.selectTotalCnt();
		System.out.println(totalCnt + "서비스");
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 버튼 번호
		int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		
		//다음 화살표 유무
		boolean next = false;
		if(listCnt * endPageBtnNo < totalCnt) {
			next = true;
		
		}else {
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt);
		
		}
		
		//이저 화살표 유무
		boolean prev = false;
		if(startPageBtnNo !=1) {
			prev = true;
			
		}

	//	System.out.println(crtPage);
	//	System.out.println(prev + "," + startPageBtnNo + "," + endPageBtnNo + "," + next);
	
		//리스트페이징정보 묶기
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("bList", bList);
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		
		System.out.println(pMap);
		
		return pMap;
	}
	
	
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
		
		/*
		//임시
		for(int i=1; i<=127; i++) {
			boardVo.setTitle(i + "번째 게시글(제목)입니다.");
			boardVo.setContent(i + "번째 게시글(내용)입니다.");
			boardDao.add(boardVo);
		}
		*/
		
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
