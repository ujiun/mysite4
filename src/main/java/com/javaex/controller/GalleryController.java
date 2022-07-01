package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryservice;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list() {
		System.out.println("GalleryController>list");
		
		return "gallery/list";
	}
	
	
	@RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST} )
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		System.out.println("GalleryController>add");
		
		String saveName = galleryservice.save(file);
		
		model.addAttribute("saveName", saveName);
		
		return "";
	}
	
}
