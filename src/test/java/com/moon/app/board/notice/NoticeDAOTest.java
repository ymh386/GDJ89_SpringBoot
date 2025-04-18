package com.moon.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moon.app.board.BoardVO;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class NoticeDAOTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void testTest()throws Exception{
		
		List<BoardVO> ar = new ArrayList<>();
		
		for(int i=0;i<100;i++) {
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardTitle("title"+i);
			boardVO.setBoardContents("contetns"+i);
			boardVO.setUserName("user"+i);
			
			ar.add(boardVO);
		}
		
		int result = noticeDAO.test(ar);
		
		log.info("Result : {}", result);
		
		assertNotEquals(0, result);
		
	}

//	@Test
	void testGetList() throws Exception {
		List<BoardVO> ar = noticeDAO.getList();
		
		for(BoardVO boardVO : ar) {
			log.info("VO : {}", boardVO);
		}
	}

//	@Test
	void testGetDetail() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardNum(1L);
		boardVO = noticeDAO.getDetail(boardVO);
		log.info("VO : {}", boardVO);
	}

//	@Test
	void testAdd() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardTitle("test");
		boardVO.setBoardContents("test");
		boardVO.setUserName("user01");
		int result = noticeDAO.add(boardVO);
		log.info("RESULT : {}", result);
	}

}
