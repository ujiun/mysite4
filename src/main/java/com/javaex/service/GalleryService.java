package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	//파일하드디스크 저장, 파일정보(DB저장) 추출
	public void save(MultipartFile file, int userNo) {
		System.out.println("GalleryService>save()");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장할 파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일사이즈
		long fileSize = file.getSize();
		
		//Vo로 묶기
		GalleryVo galleryVo= new GalleryVo(userNo, orgName, saveName, filePath, fileSize);
		System.out.println(galleryVo);
		
		//-->dao DB저장
		int count = galleryDao.add(galleryVo);
		
		System.out.println(count + "건 저장하였습니다.");
		
		//파일 하드디스크저장
		
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//리스트가져오기
	public List<GalleryVo> getList() {
		System.out.println("GalleryService>getList()");
		
		List<GalleryVo> galleryList= galleryDao.getList();
		
		return galleryList;
		
	}
	
}
