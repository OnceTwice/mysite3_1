package com.bit2016.mysite.dao.test;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;

public class UserDaoTest {
	public static void main(String[] args) {
		// insertTest();
		//getListTest();
		
		// deleteTest();
		// getListTest();
		
		updateTest();
	}
	
	public static void updateTest() {
		UserVo vo = new UserVo();
		vo.setNo(5L);
		vo.setName("abc");
		vo.setPassword("123");
		vo.setGender("male");
		
		UserDao dao = new UserDao();
		dao.update(vo);
		
	}
	
	/*
	public static void insertTest() {
		UserVo vo = new UserVo();
		vo.setName("김사나");
		vo.setContent("트와이스");
		vo.setPassword("1222222");
		
		UserDao dao = new UserDao();
		dao.insert(vo);
	}
	
	public static void deleteTest() {
		UserVo vo = new UserVo();
		vo.setNo(11L);
		vo.setPassword("1234");

		UserDao dao = new UserDao();
		dao.delete(vo);
	}
	
	public static void getListTest() {
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getList();
		for(UserVo vo : list) {
			System.out.println(vo);
		}
	}
	*/
}
