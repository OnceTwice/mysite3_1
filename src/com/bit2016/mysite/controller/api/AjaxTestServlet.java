package com.bit2016.mysite.controller.api;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.bit2016.mysite.vo.*;

import net.sf.json.*;

@WebServlet("/ajax")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json; charset=utf-8");
		/*
		 {
		 	"name" : "안대혁",
		 	"message" : "hello"
		 } 
		 */
		
		List<UserVo> list = new ArrayList<UserVo>();
		
		UserVo vo1 = new UserVo();
		vo1.setNo(10L);
		vo1.setName("안대혁");
		vo1.setEmail("kickscar@gmail.com");
		vo1.setGender("male");
		list.add(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setNo(20L);
		vo2.setName("둘리");
		vo2.setEmail("dolly@gmail.com");
		vo2.setGender("male");
		list.add(vo2);
		
		PrintWriter out = response.getWriter();
//		out.println(
//				"{" + 
//				"	\"name\" : \"안대혁\",		" +
//				"	\"message\" : \"hello\"		" +
//				"}"
//		);
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.println(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
