package com.rifat.vnoticeboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rifat.vnoticeboard.entity.Board;
import com.rifat.vnoticeboard.repository.BoardRepository;

@Controller 
public class HomeController {


	private static final Logger LOGGER =LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BoardRepository boardRepository;
	
	
	@RequestMapping(value="/" , method = RequestMethod.GET) 
	public String showhome(Model model)
	{
		
		
		List<Board> schools=boardRepository.findAll();
		
		String s[]={"hello","Kitty"};
		
		model.addAttribute("allSchool",schools);
		
		
		return "home";
	}
}
