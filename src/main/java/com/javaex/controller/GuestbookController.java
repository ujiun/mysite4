package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookController>list()");
		
		List<GuestbookVo> gList = guestbookService.getList();
		System.out.println(gList);
		
		model.addAttribute("gList", gList);
		
		return "guestbook/addList";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>add()");
		
		guestbookService.add(vo);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/deleteForm/{no}", method = { RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("GuestbookController>deleteForm()");
		
		model.addAttribute("no", no);
		
		
		return "guestbook/deleteForm";
	}	
	
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>delete()");
		
		guestbookService.delete(vo);
		return "redirect:list";
	}
}

	