package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository
public class FileDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//파일정보 저장
	public int add(FileVo fileVo) {
		System.out.println("FileDao>insert");
		
		int count = sqlSession.insert("file.insert", fileVo);
		
		return count;
	}
	
	//파일리스트 가져오기
	public List<FileVo> getList() {
		
		List<FileVo> fileList = sqlSession.selectList("file.selectList");
		
		return fileList;
	}
	
}
