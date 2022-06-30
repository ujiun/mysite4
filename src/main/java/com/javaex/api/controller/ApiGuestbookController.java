package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	
	//방명록 첫페이지(*등록폼+리스트(ajax))
	@RequestMapping(value = "/api/guestbook/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList() {
		System.out.println("ApiGuestbookController>addList()");
		
		return "apiGuestbook/addList";
	}
	
	
	//방명록 리스트 데이터만 보내줘
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<GuestbookVo> list() {
		System.out.println("ApiGuestbookController>list()");
		
		List<GuestbookVo> guestbookList = guestbookService.getList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
	//방명록 저장(ajax)
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/add", method = {RequestMethod.GET, RequestMethod.POST})
	public GuestbookVo add(@ModelAttribute GuestbookVo vo) {
		System.out.println("ApiGuestbookController>add()");
		
		System.out.println(vo);
		
		GuestbookVo gVo = guestbookService.addGuest(vo);
	
		return gVo;
	}
	
	
	//방명록 저장2(ajax)
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/add2", method = {RequestMethod.GET, RequestMethod.POST})
	public GuestbookVo add2(@RequestBody GuestbookVo vo) {
		System.out.println("ApiGuestbookController>add2()");
		
		GuestbookVo gVo = guestbookService.addGuest(vo);
	
		return gVo;
	}
	
	
	
	//방명록 삭제
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String remove(@ModelAttribute GuestbookVo vo) {
		System.out.println("ApiGuestbookController>remove()");
		
		String state = guestbookService.removeGuest(vo);
		
		return state;
	}
	
	
}
