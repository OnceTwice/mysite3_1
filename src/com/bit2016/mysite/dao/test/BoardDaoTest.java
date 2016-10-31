package com.bit2016.mysite.dao.test;

import java.util.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;

public class BoardDaoTest {
	public static void main(String[] args) {
		// insertTest();
		updateTest();
		getListTest();
	}
	
	public static void insertTest() {
		BoardVo vo = new BoardVo();
		vo.setNo(9L);
		vo.setTitle("트");
		vo.setContent("와");
		vo.setReg_date("이");
		vo.setHit("스");
		vo.setGroup_no("우");
		vo.setOrder_no("아");
		vo.setDepth("우");
		vo.setUsers_no("하");
		vo.setUsers_name("게");
		
		BoardDao dao = new BoardDao();
		dao.insert(vo);
	}
	
	public static void updateTest() {
		BoardVo vo = new BoardVo();
		vo.setTitle("하아");
		vo.setContent("ㅅㅂ");
		vo.setNo(31L);
		
		
		BoardDao dao = new BoardDao();
		dao.update(vo);
	}
	
	public static void getListTest() {
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList();
		for(BoardVo vo : list) {
			System.out.println(vo);
		}
	}
}
