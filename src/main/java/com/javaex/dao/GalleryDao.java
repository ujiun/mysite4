package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	SqlSession sqlSession;

	// 갤러리 파일 저장
	public int add(GalleryVo galleryVo) {
		System.out.println("GalleryDao>insert");

		int count = sqlSession.insert("gallery.insert", galleryVo);

		return count;
	}

	// 갤러리리스트 가져오기
	public List<GalleryVo> getList() {
		System.out.println("GalleryDao>getList");
		
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.selectList");

		return galleryList;
	}

	//getImg
	public GalleryVo getImg(int no) {
		System.out.println("GalleryDao>getImg");

		return sqlSession.selectOne("gallery.selectImg", no);
	}
	
}
