package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	//필드
	@Autowired
	UserDao userDao;
	//생성자
	
	//메소드-gs
	
	//메소드-일반
	public int join(UserVo userVo) {
		System.out.println("UserService>join()");
		
		//회원가입 비지니스 로직
		//Dao를 통해서 데이터 저장
		
		int count = userDao.userInsert(userVo);
		
		return count;
	}
}