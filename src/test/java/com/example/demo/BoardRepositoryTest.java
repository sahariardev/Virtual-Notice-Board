package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.rifat.vnoticeboard.RifatFirstApplication;
import com.rifat.vnoticeboard.entity.Board;
import com.rifat.vnoticeboard.repository.BoardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RifatFirstApplication.class)
@WebAppConfiguration
public class BoardRepositoryTest {
	
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void testfindName()
	{
		Board board1=new Board(1L,"tinytots","testpass","Simple boiard text");
		boardRepository.save(board1);
		System.out.println(boardRepository.findByName("tinytots")+"----");
	 
		
	}

}
