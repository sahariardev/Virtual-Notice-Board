package com.rifat.vnoticeboard.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rifat.vnoticeboard.dto.RegistrationForm;
import com.rifat.vnoticeboard.entity.Board;
import com.rifat.vnoticeboard.repository.BoardRepository;

@Controller
public class BoardController {

	private static final Logger LOGGER =LoggerFactory.getLogger(BoardController.class); 
	
	
	@Autowired
	BoardRepository boardRepository;
	
	
	@RequestMapping(value="/{schoolName}", method=RequestMethod.GET )
	public String showSchool(@PathVariable("schoolName") String schoolName,Model model)
	{
	    
		
		Board board=boardRepository.findByName(schoolName);
		model.addAttribute("schoolName",schoolName);
		
		if(board==null)
		{
			return "createNewBoard";
		}
		else
		{
			
			model.addAttribute("content",board.getContent());
		    return "board";
		}
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Valid RegistrationForm registrationForm,BindingResult rs, WebRequest req,RedirectAttributes model)
	{
		
		
		if(rs.hasErrors())
		{
			System.err.println("error in password ");
			model.addAttribute("error","Password mast me between 4 and 100 character");
			
		}
		else
		{
			Board board=new Board();
			board.setName(req.getParameter("name"));
			board.setPassword(req.getParameter("password"));
			System.out.println(req.getParameter("password"));
			boardRepository.save(board);
		}
		
		return "redirect:/"+req.getParameter("name");
	}
	
	@RequestMapping(value="/{schoolName}/edit", method=RequestMethod.GET )
	public String editSchool(@PathVariable("schoolName") String schoolName,Model model)
	{
	    
		
		
		Board board=boardRepository.findByName(schoolName);
		model.addAttribute("schoolName",schoolName);
		
		if(board==null)
		{
			return "createNewBoard";
		}
		else
		{
			
			model.addAttribute("content",board.getContent());
			
			
			return "edit";
		}
		
		
		
		
		
	}
	
	@RequestMapping(value="/{schoolName}/edit", method=RequestMethod.POST )
	public String submitSchool(@PathVariable("schoolName") String schoolName,Model model,WebRequest req)
	{
	    
		
		
		Board board=boardRepository.findByName(schoolName);
		
		
		
		
		
		
		model.addAttribute("schoolName",schoolName);
		
		if(board==null)
		{
			return "createNewBoard";
		}
		else
		{
			System.err.println(req.getParameter("password"));
			System.err.println(board.getPassword());
			if(board.getPassword().equals(req.getParameter("password")))
			{
				board.setContent(req.getParameter("content"));
				boardRepository.save(board);
				
			}
			else
			{
				model.addAttribute("error","Wrong Password");
			}
			
			
			model.addAttribute("content",board.getContent());
			
			
			return "edit";
		}
		
		
		
		
		
	}
}
