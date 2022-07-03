package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryservice;
	
	//리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("GalleryController>list");
		
		List<GalleryVo> galleryList = galleryservice.getList();
		
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	//업로드
	@RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST} )
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("content") String content, HttpSession session) {
		System.out.println("GalleryController>add");
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		int userNo = authUser.getNo();
		
		galleryservice.save(file, userNo, content);
		
		
		return "redirect:list";
	}

	
	
}
