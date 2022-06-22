package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	//필드
	
	@Autowired
	private BoardService boardService;
	
	//생성자
	//메소드-gs
	//메소드-일반
	
	//list
	@RequestMapping(value="/list", method= { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController>list()");

		List<BoardVo> bList= boardService.getList();
		
		model.addAttribute("bList", bList);
		
		return "board/list";
	}
	
	//sherch(-ing)
	@RequestMapping(value="/sherch", method= { RequestMethod.GET, RequestMethod.POST })
	public String search(@RequestParam(value = "keyword", required=false, defaultValue="-1") String keyword) {
		System.out.println("BoardController>search()");
		
		System.out.println(keyword);

		return "redirect:list";
	}
	
	//writeForm
	@RequestMapping(value="/writeForm", method= { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("BoardController>writeForm()");
		
		return "board/writeForm";
	}
	
	
	//write
	@RequestMapping(value="/write", method= { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>write()");
		
		
		boardService.write(boardVo);
		
		return "redirect:list";
	}
	
	//read
	@RequestMapping(value="/read/{no}", method= { RequestMethod.GET, RequestMethod.POST })
	public String read(@PathVariable("no") int no, Model model) {
		System.out.println("BoardController>read()");
		
		BoardVo boardVo = boardService.getBoard(no);
		
		model.addAttribute("boardVo", boardVo);
		
		return "board/read";
	}
	
	//delete
	@RequestMapping(value="/delete/{no}", method= { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("no") int no) {
		System.out.println("BoardController>delete()");
		
		boardService.delete(no);
		
		return "redirect:/board/list";
	}
	
	//modifyForm
	@RequestMapping(value="/modifyForm/{no}", method= { RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@PathVariable("no") int no, Model model) {
		System.out.println("BoardController>modifyForm()");
		
		BoardVo boardVo = boardService.getBoard2(no);
		
		model.addAttribute(boardVo);
		
		return "board/modifyForm";
	}
	
	//modify
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>modify()");
		
		boardService.modify(boardVo);
		
		return "redirect:/board/list";
	}
	
	
}
